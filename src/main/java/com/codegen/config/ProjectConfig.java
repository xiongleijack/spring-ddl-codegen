package com.codegen.config;

/**
 * 项目配置类，对应 codegen.yaml 配置文件的完整结构。
 * 包含项目基本信息、输出路径、生成选项和技术栈配置四个部分。
 */
public class ProjectConfig {

    /** 项目基本信息（包名、作者） */
    private ProjectSection project = new ProjectSection();
    /** 各层代码的输出路径配置 */
    private PathsSection paths = new PathsSection();
    /** 代码生成选项（导入导出、业务主键、覆盖策略） */
    private OptionsSection options = new OptionsSection();
    /** 技术栈配置（ORM框架、Lombok、Swagger） */
    private StackSection stack = new StackSection();

    public ProjectSection getProject() {
        return project;
    }

    public void setProject(ProjectSection project) {
        this.project = project;
    }

    public PathsSection getPaths() {
        return paths;
    }

    public void setPaths(PathsSection paths) {
        this.paths = paths;
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

    /**
     * 项目基本信息配置
     */
    public static class ProjectSection {
        /** 生成代码的基础包名 */
        private String basePackage = "com.example.demo";
        /** 代码作者，用于 @author 注解 */
        private String author = "codegen";

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
    }

    /**
     * 各层代码文件的输出路径配置。
     * 每个路径为相对于项目根目录的相对路径。
     */
    public static class PathsSection {
        /** 实体类(DO)输出路径 */
        private String entity = "src/main/java/com/example/demo/model/entity";
        /** Mapper接口输出路径 */
        private String mapper = "src/main/java/com/example/demo/mapper";
        /** DAO数据访问层输出路径 */
        private String dao = "src/main/java/com/example/demo/dao";
        /** Service接口输出路径 */
        private String service = "src/main/java/com/example/demo/service";
        /** Service实现类输出路径 */
        private String serviceImpl = "src/main/java/com/example/demo/service/impl";
        /** Controller控制器输出路径 */
        private String controller = "src/main/java/com/example/demo/controller/management";
        /** DTO数据传输对象输出路径 */
        private String dto = "src/main/java/com/example/demo/model/dto";
        /** BO业务对象输出路径 */
        private String bo = "src/main/java/com/example/demo/model/bo";

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

        public String getMapper() {
            return mapper;
        }

        public void setMapper(String mapper) {
            this.mapper = mapper;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getServiceImpl() {
            return serviceImpl;
        }

        public void setServiceImpl(String serviceImpl) {
            this.serviceImpl = serviceImpl;
        }

        public String getController() {
            return controller;
        }

        public void setController(String controller) {
            this.controller = controller;
        }

        public String getDao() {
            return dao;
        }

        public void setDao(String dao) {
            this.dao = dao;
        }

        public String getDto() {
            return dto;
        }

        public void setDto(String dto) {
            this.dto = dto;
        }

        public String getBo() {
            return bo;
        }

        public void setBo(String bo) {
            this.bo = bo;
        }
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
