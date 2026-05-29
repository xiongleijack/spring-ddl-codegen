package com.codegen.generator;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NamingUtils {

    private static final Pattern UNDERSCORE = Pattern.compile("_([a-z])");

    private NamingUtils() {
    }

    public static String toClassName(String tableName) {
        return toUpperCamel(stripTablePrefix(tableName));
    }

    public static String toVariableName(String tableName) {
        String className = toClassName(tableName);
        if (className.isEmpty()) {
            return className;
        }
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    public static String toFieldName(String columnName) {
        return toLowerCamel(columnName);
    }

    public static String toUpperCamel(String value) {
        String lowerCamel = toLowerCamel(value);
        if (lowerCamel.isEmpty()) {
            return lowerCamel;
        }
        return Character.toUpperCase(lowerCamel.charAt(0)) + lowerCamel.substring(1);
    }

    public static String toLowerCamel(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "";
        }
        String normalized = value.trim().toLowerCase(Locale.ROOT);
        Matcher matcher = UNDERSCORE.matcher(normalized);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, matcher.group(1).toUpperCase(Locale.ROOT));
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }

    private static String stripTablePrefix(String tableName) {
        String normalized = tableName;
        if (normalized.startsWith("`") && normalized.endsWith("`")) {
            normalized = normalized.substring(1, normalized.length() - 1);
        }
        if (normalized.startsWith("t_")) {
            return normalized.substring(2);
        }
        if (normalized.startsWith("tb_")) {
            return normalized.substring(3);
        }
        return normalized;
    }
}
