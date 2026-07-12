package com.codegen.config;

import com.codegen.generator.NamingUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分组 DO / GroupMapper / GroupDAO 配置，对应 codegen.yaml 中的 groupDos 列表项。
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
    /**
     * GroupDAO 类名，例如 OnshoreBondFilterV5ComUniCodeGroupDAO。
     * 不配则默认将 className 的 GroupDO 后缀替换为 GroupDAO。
     */
    private String daoClassName;
    /**
     * 有效数据过滤（可选）。配置后 GroupDAO 两个查询都会加上
     * {@code .and(SourceDO::getXxx, isEqual(value))}。
     * 例如 field=deleted, value=0 表示只查未删除。
     */
    private ValidFilter validFilter;
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

    public String getDaoClassName() {
        return daoClassName;
    }

    public void setDaoClassName(String daoClassName) {
        this.daoClassName = daoClassName;
    }

    public ValidFilter getValidFilter() {
        return validFilter;
    }

    public void setValidFilter(ValidFilter validFilter) {
        this.validFilter = validFilter;
    }

    public String resolveMapperClassName() {
        if (mapperClassName != null && !mapperClassName.trim().isEmpty()) {
            return mapperClassName.trim();
        }
        return replaceGroupDoSuffix("GroupMapper");
    }

    public String resolveDaoClassName() {
        if (daoClassName != null && !daoClassName.trim().isEmpty()) {
            return daoClassName.trim();
        }
        return replaceGroupDoSuffix("GroupDAO");
    }

    private String replaceGroupDoSuffix(String suffix) {
        if (className == null) {
            return null;
        }
        if (className.endsWith("GroupDO")) {
            return className.substring(0, className.length() - "GroupDO".length()) + suffix;
        }
        if (className.endsWith("DO")) {
            return className.substring(0, className.length() - 2) + suffix;
        }
        return className + suffix;
    }

    public List<GroupDoField> getFields() {
        return fields;
    }

    public void setFields(List<GroupDoField> fields) {
        this.fields = fields;
    }

    /** 分组键字段（非聚合） */
    public List<GroupDoField> resolveGroupKeys() {
        List<GroupDoField> keys = new ArrayList<GroupDoField>();
        if (fields == null) {
            return keys;
        }
        for (GroupDoField field : fields) {
            if (field.isGroupByKey()) {
                keys.add(field);
            }
        }
        return keys;
    }

    /** 可用于「按 GroupDO 反查源表」的字段（能映射到源表列） */
    public List<GroupDoField> resolveMatchFields() {
        List<GroupDoField> matchFields = new ArrayList<GroupDoField>();
        if (fields == null) {
            return matchFields;
        }
        for (GroupDoField field : fields) {
            if (field.resolveSourceJavaName() != null) {
                matchFields.add(field);
            }
        }
        return matchFields;
    }

    /**
     * 源表有效/无效过滤条件。
     */
    public static class ValidFilter {
        /** 源表 DO 字段名，例如 deleted / validStatus */
        private String field;
        /** 有效值，例如 0（未删除）、1（有效） */
        private Object value;

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public boolean isConfigured() {
            return field != null && !field.trim().isEmpty() && value != null;
        }

        /** 生成到 Java 源码中的字面量 */
        public String toJavaLiteral() {
            if (value instanceof String) {
                return "\"" + value.toString().replace("\"", "\\\"") + "\"";
            }
            if (value instanceof Boolean || value instanceof Number) {
                return value.toString();
            }
            return String.valueOf(value);
        }
    }

    /**
     * 分组 DO 中的单个字段。
     */
    public static class GroupDoField {
        /** Java 字段名，例如 comUniCode / maxIssueStartDate */
        private String name;
        /** Java 类型，例如 Long / Integer / java.sql.Date / java.math.BigDecimal */
        private String type;
        /**
         * @Column(name = "...") 的值；不配则仅生成 @Column。
         * 聚合场景写 SQL 表达式，如 max(default_date)、count(*)。
         */
        private String column;
        /**
         * 源表 DO 上对应的 Java 字段名。
         * 不配则：聚合表达式从 max(issue_start_date) 解析为 issueStartDate；否则用 name。
         */
        private String sourceName;
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

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public boolean isAggregate() {
            return column != null && column.contains("(");
        }

        public boolean isGroupByKey() {
            return !isAggregate();
        }

        /**
         * 源表 DO 字段名；count(*) 等无法映射时返回 null。
         */
        public String resolveSourceJavaName() {
            if (sourceName != null && !sourceName.trim().isEmpty()) {
                return sourceName.trim();
            }
            if (column != null && !column.trim().isEmpty()) {
                String col = column.trim();
                if (col.contains("(")) {
                    int start = col.indexOf('(') + 1;
                    int end = col.lastIndexOf(')');
                    if (end > start) {
                        String inner = col.substring(start, end).trim();
                        if ("*".equals(inner) || inner.isEmpty()) {
                            return null;
                        }
                        return NamingUtils.toFieldName(inner);
                    }
                    return null;
                }
                return NamingUtils.toFieldName(col);
            }
            return name;
        }
    }
}
