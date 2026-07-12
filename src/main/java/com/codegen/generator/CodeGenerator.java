package com.codegen.generator;

import com.codegen.config.GroupDoConfig;
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
        generateGroupDos();
    }

    /**
     * 为单张表生成所有代码文件。
     * 核心层: DO -> Mapper -> DAO -> Service -> ServiceImpl -> Controller
     * 数据层: DetailDTO, QueryDTO, PageDTO, QueryBO
     * 可选层: canalDto；只读场景用 readonlyDao 替代 dao（同名 XxxDAO.java，勿同时开启）
     */
    private void generateForTable(TableDefinition table) {
        Map<String, Object> model = buildModel(table);
        List<String> enabledTemplates = config.getTemplates();
        List<GeneratedFile> files = new ArrayList<>();

        if (enabledTemplates.contains("do")) {
            files.add(new GeneratedFile(config.getResolvedPath("entity"), table.getClassName() + "DO.java", "do.ftl", model));
        }
        if (enabledTemplates.contains("mapper")) {
            files.add(new GeneratedFile(config.getResolvedPath("mapper"), table.getClassName() + "Mapper.java", "mapper.ftl", model));
        }
        if (enabledTemplates.contains("dao")) {
            files.add(new GeneratedFile(config.getResolvedPath("dao"), table.getClassName() + "DAO.java", "dao.ftl", model));
        }
        if (enabledTemplates.contains("readonlyDao")) {
            files.add(new GeneratedFile(config.getResolvedPath("dao"), table.getClassName() + "DAO.java", "readonlyDao.ftl", model));
        }
        if (enabledTemplates.contains("service")) {
            files.add(new GeneratedFile(config.getResolvedPath("service"), table.getClassName() + "Service.java", "service.ftl", model));
        }
        if (enabledTemplates.contains("serviceImpl")) {
            files.add(new GeneratedFile(config.getResolvedPath("serviceImpl"), table.getClassName() + "ServiceImpl.java", "serviceImpl.ftl", model));
        }
        if (enabledTemplates.contains("mgtController")) {
            files.add(new GeneratedFile(config.getResolvedPath("controller"), "Mgt" + table.getClassName() + "Controller.java", "mgtController.ftl", model));
        }
        if (enabledTemplates.contains("internalController")) {
            files.add(new GeneratedFile(config.getResolvedPath("internalController"), "Internal" + table.getClassName() + "Controller.java", "internalController.ftl", model));
        }
        if (enabledTemplates.contains("detailDto")) {
            files.add(new GeneratedFile(config.getResolvedPath("dto"), table.getClassName() + "DetailDTO.java", "detailDto.ftl", model));
        }
        if (enabledTemplates.contains("queryDto")) {
            files.add(new GeneratedFile(config.getResolvedPath("dto") + "/request", table.getClassName() + "QueryDTO.java", "queryDto.ftl", model));
        }
        if (enabledTemplates.contains("pageDto")) {
            files.add(new GeneratedFile(config.getResolvedPath("dto") + "/response", table.getClassName() + "PageDTO.java", "pageDto.ftl", model));
        }
        if (enabledTemplates.contains("queryBo")) {
            files.add(new GeneratedFile(config.getResolvedPath("bo"), table.getClassName() + "QueryBO.java", "queryBo.ftl", model));
        }
        if (enabledTemplates.contains("canalDto") || enabledTemplates.contains("canalDTO")) {
            files.add(new GeneratedFile(config.getResolvedPath("dto") + "/canal", table.getClassName() + "CanalDTO.java", "canalDto.ftl", model));
        }

        for (GeneratedFile file : files) {
            writeFile(file);
        }
    }

    /**
     * 根据 groupDos 配置生成分组 DO / GroupMapper / GroupDAO（与表循环无关）。
     */
    private void generateGroupDos() {
        boolean generateDo = config.getTemplates().contains("groupDo");
        boolean generateMapper = config.getTemplates().contains("groupMapper");
        boolean generateDao = config.getTemplates().contains("groupDao");
        if (!generateDo && !generateMapper && !generateDao) {
            return;
        }
        List<GroupDoConfig> groupDos = config.getGroupDos();
        if (groupDos == null || groupDos.isEmpty()) {
            System.out.println("[skip] templates 含 groupDo/groupMapper/groupDao，但未配置 groupDos");
            return;
        }
        for (GroupDoConfig groupDo : groupDos) {
            if (groupDo.getClassName() == null || groupDo.getClassName().trim().isEmpty()) {
                throw new IllegalArgumentException("groupDos.className 不能为空");
            }
            if (generateDo) {
                if (groupDo.getFields() == null || groupDo.getFields().isEmpty()) {
                    throw new IllegalArgumentException("groupDos.fields 不能为空: " + groupDo.getClassName());
                }
                Map<String, Object> model = buildGroupDoModel(groupDo);
                writeFile(new GeneratedFile(
                        config.getResolvedPath("groupEntity"),
                        groupDo.getClassName() + ".java",
                        "groupDo.ftl",
                        model
                ));
            }
            if (generateMapper) {
                requireSourceTable(groupDo, "groupMapper");
                Map<String, Object> model = buildGroupMapperModel(groupDo);
                writeFile(new GeneratedFile(
                        config.getResolvedPath("groupMapper"),
                        groupDo.resolveMapperClassName() + ".java",
                        "groupMapper.ftl",
                        model
                ));
            }
            if (generateDao) {
                requireSourceTable(groupDo, "groupDao");
                if (groupDo.resolveGroupKeys().isEmpty()) {
                    throw new IllegalArgumentException(
                            "生成 groupDao 时至少需要一个分组键字段（无聚合表达式的字段）: "
                                    + groupDo.getClassName());
                }
                if (groupDo.resolveMatchFields().isEmpty()) {
                    throw new IllegalArgumentException(
                            "生成 groupDao 时至少需要一个可映射到源表的字段: " + groupDo.getClassName());
                }
                Map<String, Object> model = buildGroupDaoModel(groupDo);
                writeFile(new GeneratedFile(
                        config.getResolvedPath("groupDao"),
                        groupDo.resolveDaoClassName() + ".java",
                        "groupDao.ftl",
                        model
                ));
            }
        }
    }

    private void requireSourceTable(GroupDoConfig groupDo, String templateName) {
        if (groupDo.getSourceTable() == null || groupDo.getSourceTable().trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "生成 " + templateName + " 时必须配置 groupDos.sourceTable: " + groupDo.getClassName());
        }
    }

    private Map<String, Object> buildGroupDoModel(GroupDoConfig groupDo) {
        Map<String, Object> model = new HashMap<>();
        model.put("config", config);
        model.put("groupDo", groupDo);
        model.put("basePackage", config.getProject().getBasePackage());
        model.put("author", config.getProject().getAuthor());
        model.put("databasePackage", config.getDatabasePackage());
        model.put("util", new TemplateUtils());
        model.put("importTypes", collectGroupDoImportTypes(groupDo));
        return model;
    }

    private Map<String, Object> buildGroupMapperModel(GroupDoConfig groupDo) {
        Map<String, Object> model = buildGroupDoModel(groupDo);
        putSourceDoNames(model, groupDo);
        model.put("mapperClassName", groupDo.resolveMapperClassName());
        return model;
    }

    private Map<String, Object> buildGroupDaoModel(GroupDoConfig groupDo) {
        Map<String, Object> model = buildGroupMapperModel(groupDo);
        TemplateUtils util = new TemplateUtils();
        String mapperClassName = groupDo.resolveMapperClassName();
        String sourceDoSimpleName = (String) model.get("sourceDoSimpleName");
        String sourceMapperClassName = sourceDoSimpleName.substring(0, sourceDoSimpleName.length() - 2) + "Mapper";
        List<GroupDoConfig.GroupDoField> groupKeys = groupDo.resolveGroupKeys();

        model.put("daoClassName", groupDo.resolveDaoClassName());
        model.put("mapperVarName", util.firstLower(mapperClassName));
        model.put("sourceMapperClassName", sourceMapperClassName);
        model.put("sourceMapperVarName", util.firstLower(sourceMapperClassName));
        model.put("groupKeys", groupKeys);
        model.put("primaryGroupKey", groupKeys.get(0));
        model.put("matchFields", groupDo.resolveMatchFields());

        GroupDoConfig.ValidFilter validFilter = groupDo.getValidFilter();
        boolean hasValidFilter = validFilter != null && validFilter.isConfigured();
        model.put("hasValidFilter", hasValidFilter);
        model.put("validFilter", validFilter);
        model.put("validFilterLiteral", hasValidFilter ? validFilter.toJavaLiteral() : null);
        return model;
    }

    private void putSourceDoNames(Map<String, Object> model, GroupDoConfig groupDo) {
        String sourceTable = groupDo.getSourceTable().trim();
        String sourceDoSimpleName = NamingUtils.toClassName(sourceTable) + "DO";
        String dbPkg = config.getDatabasePackage();
        String entityPkg = config.getProject().getBasePackage() + ".model.entity"
                + (dbPkg == null || dbPkg.isEmpty() ? "" : "." + dbPkg);
        model.put("sourceDoFullName", entityPkg + "." + sourceDoSimpleName);
        model.put("sourceDoSimpleName", sourceDoSimpleName);
    }

    private List<String> collectGroupDoImportTypes(GroupDoConfig groupDo) {
        Set<String> imports = new LinkedHashSet<String>();
        if (groupDo.getFields() == null) {
            return new ArrayList<String>(imports);
        }
        for (GroupDoConfig.GroupDoField field : groupDo.getFields()) {
            String javaType = field.getType();
            if (javaType == null || javaType.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "groupDos.fields.type 不能为空: " + groupDo.getClassName() + "." + field.getName());
            }
            if (javaType.contains(".") && !javaType.startsWith("java.lang.")) {
                imports.add(javaType);
            } else if ("Date".equals(javaType) || "java.sql.Date".equals(javaType)) {
                imports.add("java.sql.Date");
            } else if ("BigDecimal".equals(javaType)) {
                imports.add("java.math.BigDecimal");
            }
        }
        return new ArrayList<String>(imports);
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
        model.put("databasePackage", config.getDatabasePackage());
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
