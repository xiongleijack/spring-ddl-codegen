package com.codegen.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 分组 DO / GroupMapper 配置，对应 codegen.yaml 中的 groupDos 列表项。
 * 用于生成 wz2cool GroupByQuery 使用的聚合结果对象及 SelectByGroupedQueryMapper。
 */
public class GroupDoConfig {

    /** 完整类名，例如 DefaultComLatestDefaultDateGroupDO */
    private String className;
    /** 类注释 */
    private String comment = "";
    /**
     * 分组查询的源表名，例如 default_bond_info。
     * 生成时按命名规则转为源 DO：default_bond_info → DefaultBondInfoDO。
     */
    private String sourceTable;
    /**
     * GroupMapper 类名，例如 DefaultComLatestBondGroupMapper。
     * 不配则默认将 className 的 GroupDO 后缀替换为 GroupMapper。
     */
    private String mapperClassName;
    /** 字段列表（分组键 + 聚合字段） */
    private List<GroupDoField> fields = new ArrayList<GroupDoField>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

    public String getMapperClassName() {
        return mapperClassName;
    }

    public void setMapperClassName(String mapperClassName) {
        this.mapperClassName = mapperClassName;
    }

    /**
     * 解析 GroupMapper 类名：优先用配置，否则由 GroupDO 类名推导。
     */
    public String resolveMapperClassName() {
        if (mapperClassName != null && !mapperClassName.trim().isEmpty()) {
            return mapperClassName.trim();
        }
        if (className == null) {
            return null;
        }
        if (className.endsWith("GroupDO")) {
            return className.substring(0, className.length() - "GroupDO".length()) + "GroupMapper";
        }
        if (className.endsWith("DO")) {
            return className.substring(0, className.length() - 2) + "GroupMapper";
        }
        return className + "GroupMapper";
    }

    public List<GroupDoField> getFields() {
        return fields;
    }

    public void setFields(List<GroupDoField> fields) {
        this.fields = fields;
    }

    /**
     * 分组 DO 中的单个字段。
     * <ul>
     *   <li>分组键：不配 column，生成 {@code @Column}</li>
     *   <li>普通列映射：{@code column: expire_date}</li>
     *   <li>聚合表达式：{@code column: max(default_date)} 或 {@code column: SUM(bond_balance)}</li>
     * </ul>
     */
    public static class GroupDoField {
        /** Java 字段名，例如 comUniCode / defaultDate */
        private String name;
        /** Java 类型，例如 Long / Integer / java.sql.Date / java.math.BigDecimal */
        private String type;
        /**
         * @Column(name = "...") 的值；不配则仅生成 @Column。
         * 聚合场景写 SQL 表达式，如 max(default_date)、count(*)。
         */
        private String column;
        /** 字段注释 */
        private String comment = "";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getColumn() {
            return column;
        }

        public void setColumn(String column) {
            this.column = column;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
