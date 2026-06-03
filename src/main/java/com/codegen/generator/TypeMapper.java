package com.codegen.generator;

import com.codegen.model.ColumnDefinition;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TypeMapper {

    private static final Pattern BASE_TYPE = Pattern.compile("([a-zA-Z]+)");
    private static final Map<String, String> TYPE_MAPPING = new HashMap<>();

    static {
        TYPE_MAPPING.put("tinyint", "Integer");
        TYPE_MAPPING.put("smallint", "Integer");
        TYPE_MAPPING.put("mediumint", "Integer");
        TYPE_MAPPING.put("int", "Integer");
        TYPE_MAPPING.put("integer", "Integer");
        TYPE_MAPPING.put("bigint", "Long");
        TYPE_MAPPING.put("float", "Float");
        TYPE_MAPPING.put("double", "Double");
        TYPE_MAPPING.put("decimal", "java.math.BigDecimal");
        TYPE_MAPPING.put("numeric", "java.math.BigDecimal");
        TYPE_MAPPING.put("char", "String");
        TYPE_MAPPING.put("varchar", "String");
        TYPE_MAPPING.put("text", "String");
        TYPE_MAPPING.put("tinytext", "String");
        TYPE_MAPPING.put("mediumtext", "String");
        TYPE_MAPPING.put("longtext", "String");
        TYPE_MAPPING.put("date", "java.sql.Date");
        TYPE_MAPPING.put("datetime", "java.sql.Timestamp");
        TYPE_MAPPING.put("timestamp", "java.sql.Timestamp");
        TYPE_MAPPING.put("time", "java.sql.Time");
        TYPE_MAPPING.put("bit", "Boolean");
        TYPE_MAPPING.put("boolean", "Boolean");
        TYPE_MAPPING.put("bool", "Boolean");
        TYPE_MAPPING.put("blob", "byte[]");
        TYPE_MAPPING.put("binary", "byte[]");
        TYPE_MAPPING.put("varbinary", "byte[]");
    }

    private TypeMapper() {
    }

    public static void applyJavaType(ColumnDefinition column) {
        String baseType = extractBaseType(column.getSqlType());
        column.setJavaType(mapSqlType(baseType));
    }

    public static String mapSqlType(String sqlType) {
        String normalized = sqlType.toLowerCase(Locale.ROOT);
        return TYPE_MAPPING.getOrDefault(normalized, "String");
    }

    public static String simpleJavaType(String fullJavaType) {
        int index = fullJavaType.lastIndexOf('.');
        return index >= 0 ? fullJavaType.substring(index + 1) : fullJavaType;
    }

    private static String extractBaseType(String sqlType) {
        if (sqlType == null || sqlType.trim().isEmpty()) {
            return "varchar";
        }
        Matcher matcher = BASE_TYPE.matcher(sqlType.trim().toLowerCase(Locale.ROOT));
        if (matcher.find()) {
            return matcher.group(1);
        }
        return sqlType.trim().toLowerCase(Locale.ROOT);
    }
}
