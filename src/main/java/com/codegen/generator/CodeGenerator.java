package com.codegen.generator;

import com.codegen.config.ProjectConfig;
import com.codegen.model.ColumnDefinition;
import com.codegen.model.TableDefinition;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 代码生成器核心类。
 * 负责将DDL解析后的表定义与FreeMarker模板结合，生成完整的分层代码文件。
 * 生成的文件包括: DO实体、Mapper、DAO、Service、ServiceImpl、Controller、DTO、BO。
 */
public class CodeGenerator {

    /** 项目配置（包名、路径、技术栈等） */
    private final ProjectConfig config;
    /** 项目根目录，生成文件的基准路径 */
    private final Path projectRoot;
    /** dry-run模式：仅打印文件路径，不实际写入 */
    private final boolean dryRun;
    /** write模式：是否实际写入文件到磁盘 */
    private final boolean write;
    /** FreeMarker模板渲染器 */
    private final TemplateRenderer templateRenderer = new TemplateRenderer();

    public CodeGenerator(ProjectConfig config, Path projectRoot, boolean dryRun, boolean write) {
        this.config = config;
        this.projectRoot = projectRoot;
        this.dryRun = dryRun;
        this.write = write;
    }

    /**
     * 对所有表执行代码生成。
     * 先解析业务主键，再逐表生成全部分层代码文件。
     *
     * @param tables DDL解析后的表定义列表
     */
    public void generateAll(List<TableDefinition> tables) {
        for (TableDefinition table : tables) {
            table.setBusinessKey(BusinessKeyResolver.resolve(table, config.getOptions().getBusinessKey()));
            generateForTable(table);
        }
    }

    /**
     * 为单张表生成所有代码文件。
     * 核心层: DO -> Mapper -> DAO -> Service -> ServiceImpl -> Controller
     * 数据层: DetailDTO, QueryDTO, PageDTO, QueryBO
     * 可选层: ImportController, ExportController
     */
    private void generateForTable(TableDefinition table) {
        Map<String, Object> model = buildModel(table);
        List<GeneratedFile> files = new ArrayList<>();
        files.add(new GeneratedFile(config.getPaths().getEntity(), table.getClassName() + "DO.java", "do.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getMapper(), table.getClassName() + "Mapper.java", "mapper.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getDao(), table.getClassName() + "DAO.java", "dao.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getService(), table.getClassName() + "Service.java", "service.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getServiceImpl(), table.getClassName() + "ServiceImpl.java", "serviceImpl.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getController(), "Mgt" + table.getClassName() + "Controller.java", "controller.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getDto(), table.getClassName() + "DetailDTO.java", "detailDto.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getDto() + "/request", table.getClassName() + "QueryDTO.java", "queryDto.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getDto() + "/response", table.getClassName() + "PageDTO.java", "pageDto.ftl", model));
        files.add(new GeneratedFile(config.getPaths().getBo(), table.getClassName() + "QueryBO.java", "queryBo.ftl", model));

        if (config.getOptions().isEnableImport()) {
            files.add(new GeneratedFile(
                    config.getPaths().getController(),
                    table.getClassName() + "ImportController.java",
                    "importController.ftl",
                    model
            ));
        }
        if (config.getOptions().isEnableExport()) {
            files.add(new GeneratedFile(
                    config.getPaths().getController(),
                    table.getClassName() + "ExportController.java",
                    "exportController.ftl",
                    model
            ));
        }

        for (GeneratedFile file : files) {
            writeFile(file);
        }
    }

    /**
     * 构建模板渲染所需的数据模型（Map）。
     * 模板中可通过 ${key} 访问这些变量。
     *
     * @param table 表定义
     * @return 模板数据模型
     */
    private Map<String, Object> buildModel(TableDefinition table) {
        Map<String, Object> model = new HashMap<>();
        model.put("config", config);
        model.put("table", table);
        model.put("basePackage", config.getProject().getBasePackage());
        model.put("author", config.getProject().getAuthor());
        model.put("pk", table.getPrimaryKey());
        model.put("businessKey", table.getBusinessKey());
        model.put("hasBusinessKey", table.getBusinessKey() != null);
        model.put("enableImport", config.getOptions().isEnableImport());
        model.put("enableExport", config.getOptions().isEnableExport());
        model.put("util", new TemplateUtils());
        model.put("importTypes", collectImportTypes(table));
        return model;
    }

    /**
     * 收集表中所有需要import的Java类型（排除java.lang包下的类型）。
     * 用于模板中生成import语句。
     *
     * @param table 表定义
     * @return 需要导入的全限定类型列表
     */
    private List<String> collectImportTypes(TableDefinition table) {
        Set<String> imports = new LinkedHashSet<String>();
        for (ColumnDefinition column : table.getColumns()) {
            String javaType = column.getJavaType();
            if (javaType.contains(".") && !javaType.startsWith("java.lang.")) {
                imports.add(javaType);
            }
        }
        return new ArrayList<String>(imports);
    }

    /**
     * 将渲染后的代码内容写入目标文件。
     * 支持dry-run模式（仅打印路径）和overwrite控制。
     *
     * @param file 待写入的生成文件描述
     */
    private void writeFile(GeneratedFile file) {
        String content = templateRenderer.render(file.getTemplateName(), file.getModel());
        Path targetPath = projectRoot.resolve(file.getRelativePath()).resolve(file.getFileName()).normalize();

        if (dryRun) {
            System.out.println("[dry-run] " + targetPath);
            return;
        }

        if (!write) {
            return;
        }

        try {
            if (Files.exists(targetPath) && !config.getOptions().isOverwrite()) {
                System.out.println("[skip] " + targetPath + " (already exists, use options.overwrite=true)");
                return;
            }
            Files.createDirectories(targetPath.getParent());
            Files.write(targetPath, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("[write] " + targetPath);
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to write generated file: " + targetPath, ex);
        }
    }

    /**
     * 生成文件的描述信息，包含输出路径、文件名、使用的模板和数据模型。
     */
    private static final class GeneratedFile {
        /** 相对于项目根目录的输出目录路径 */
        private final String relativePath;
        /** 生成的文件名 */
        private final String fileName;
        /** 使用的FreeMarker模板名称 */
        private final String templateName;
        /** 传递给模板的数据模型 */
        private final Map<String, Object> model;

        private GeneratedFile(String relativePath, String fileName, String templateName, Map<String, Object> model) {
            this.relativePath = relativePath;
            this.fileName = fileName;
            this.templateName = templateName;
            this.model = model;
        }

        private String getRelativePath() {
            return relativePath;
        }

        private String getFileName() {
            return fileName;
        }

        private String getTemplateName() {
            return templateName;
        }

        private Map<String, Object> getModel() {
            return model;
        }
    }
}
