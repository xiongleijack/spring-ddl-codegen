package com.codegen.config;

import java.util.Arrays;
import java.util.List;

/**
 * 项目配置类，对应 codegen.yaml 配置文件的完整结构。
 * 包含项目基本信息、输出路径、生成选项和技术栈配置四个部分。
 */
public class ProjectConfig {

    /** 项目基本信息（包名、作者、数据库名） */
    private ProjectSection project = new ProjectSection();
    /** 代码生成选项（导入导出、业务主键、覆盖策略） */
    private OptionsSection options = new OptionsSection();
    /** 技术栈配置（ORM框架、Lombok、Swagger） */
    private StackSection stack = new StackSection();
    /** 要生成的模板列表，不配置则全部生成 */
    private List<String> templates = Arrays.asList(
            "do", "mapper", "dao", "service", "serviceImpl",
            "controller", "detailDto", "queryDto", "pageDto", "queryBo"
    );
    /** DDL文件路径（相对于配置文件所在目录） */
    private String ddl;

    public ProjectSection getProject() {
        return project;
    }

    public void setProject(ProjectSection project) {
        this.project = project;
    }

    public OptionsSection getOptions() {
        return options;
    }

    public void setOptions(OptionsSection options) {
        this.options = options;
    }

    public StackSection getStack() {
        return stack;
    }

    public void setStack(StackSection stack) {
        this.stack = stack;
    }

    public List<String> getTemplates() {
        return templates;
    }

    public void setTemplates(List<String> templates) {
        this.templates = templates;
    }

    public String getDdl() {
        return ddl;
    }

    public void setDdl(String ddl) {
        this.ddl = ddl;
    }

    /**
     * 项目基本信息配置
     */
    public static class ProjectSection {
        /** 生成代码的基础包名 */
        private String basePackage = "com.example.demo";
        /** 代码作者，用于 @author 注解 */
        private String author = "codegen";
        /** 数据库名称，entity/mapper/dao 层会加上对应子包（去下划线全小写） */
        private String database;

        public String getBasePackage() {
            return basePackage;
        }

        public void setBasePackage(String basePackage) {
            this.basePackage = basePackage;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }
    }

    /**
     * 根据 basePackage 和 database 自动推导各层代码输出路径。
     *
     * @param layer 层名称: entity/mapper/dao/service/serviceImpl/controller/dto/bo
     * @return 相对于项目根目录的输出路径
     */
    public String getResolvedPath(String layer) {
        String basePath = "src/main/java/" + project.getBasePackage().replace('.', '/');
        String dbSuffix = getDatabaseSuffix();
        switch (layer) {
            case "entity":      return basePath + "/model/entity" + dbSuffix;
            case "mapper":      return basePath + "/mapper" + dbSuffix;
            case "dao":         return basePath + "/dao" + dbSuffix;
            case "service":     return basePath + "/service";
            case "serviceImpl": return basePath + "/service/impl";
            case "controller":  return basePath + "/controller/management";
            case "dto":         return basePath + "/model/dto";
            case "bo":          return basePath + "/model/bo";
            default: throw new IllegalArgumentException("Unknown layer: " + layer);
        }
    }

    /**
     * 获取数据库名对应的包名后缀（去下划线、全小写）。
     * 若未配置 database 则返回空串。
     */
    public String getDatabasePackage() {
        if (project.getDatabase() == null || project.getDatabase().isEmpty()) {
            return "";
        }
        return project.getDatabase().replace("_", "").toLowerCase();
    }

    private String getDatabaseSuffix() {
        String dbPkg = getDatabasePackage();
        return dbPkg.isEmpty() ? "" : "/" + dbPkg;
    }

    /**
     * 代码生成选项配置
     */
    public static class OptionsSection {
        /** 是否生成数据导入Controller */
        private boolean enableImport = false;
        /** 是否生成数据导出Controller */
        private boolean enableExport = false;
        /** 业务主键策略: "auto"自动识别唯一索引, 或指定列名 */
        private String businessKey = "auto";
        /** 文件已存在时是否覆盖 */
        private boolean overwrite = false;

        public boolean isEnableImport() {
            return enableImport;
        }

        public void setEnableImport(boolean enableImport) {
            this.enableImport = enableImport;
        }

        public boolean isEnableExport() {
            return enableExport;
        }

        public void setEnableExport(boolean enableExport) {
            this.enableExport = enableExport;
        }

        public String getBusinessKey() {
            return businessKey;
        }

        public void setBusinessKey(String businessKey) {
            this.businessKey = businessKey;
        }

        public boolean isOverwrite() {
            return overwrite;
        }

        public void setOverwrite(boolean overwrite) {
            this.overwrite = overwrite;
        }
    }

    /**
     * 技术栈配置，控制生成代码所使用的框架和工具
     */
    public static class StackSection {
        /** ORM框架: "mybatis-plus" */
        private String orm = "mybatis-plus";
        /** 是否使用Lombok（@Data注解替代getter/setter） */
        private boolean lombok = true;
        /** 是否生成Swagger/OpenAPI注解 */
        private boolean swagger = true;

        public String getOrm() {
            return orm;
        }

        public void setOrm(String orm) {
            this.orm = orm;
        }

        public boolean isLombok() {
            return lombok;
        }

        public void setLombok(boolean lombok) {
            this.lombok = lombok;
        }

        public boolean isSwagger() {
            return swagger;
        }

        public void setSwagger(boolean swagger) {
            this.swagger = swagger;
        }
    }
}
