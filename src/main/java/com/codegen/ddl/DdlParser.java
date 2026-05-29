package com.codegen.ddl;

import com.codegen.generator.BusinessKeyResolver;
import com.codegen.generator.NamingUtils;
import com.codegen.generator.TypeMapper;
import com.codegen.model.ColumnDefinition;
import com.codegen.model.IndexDefinition;
import com.codegen.model.TableDefinition;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DdlParser {

    private static final Pattern CREATE_TABLE_START = Pattern.compile(
            "CREATE\\s+TABLE\\s+(?:IF\\s+NOT\\s+EXISTS\\s+)?([`\\w]+)\\s*\\(",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern TABLE_COMMENT = Pattern.compile(
            "COMMENT\\s*=\\s*'((?:''|[^'])*)'",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern COLUMN_DEF = Pattern.compile(
            "^[`\"]?([\\w]+)[`\"]?\\s+([\\w]+(?:\\s*\\([^)]*\\))?)\\s*(.*)$",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern PRIMARY_KEY_INLINE = Pattern.compile(
            "PRIMARY\\s+KEY",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern AUTO_INCREMENT = Pattern.compile("AUTO_INCREMENT", Pattern.CASE_INSENSITIVE);
    private static final Pattern NOT_NULL = Pattern.compile("NOT\\s+NULL", Pattern.CASE_INSENSITIVE);
    private static final Pattern COMMENT = Pattern.compile("COMMENT\\s+'((?:''|[^'])*)'", Pattern.CASE_INSENSITIVE);
    private static final Pattern PRIMARY_KEY_DEF = Pattern.compile(
            "PRIMARY\\s+KEY\\s*\\(([^)]+)\\)",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern UNIQUE_KEY_DEF = Pattern.compile(
            "UNIQUE\\s+(?:KEY|INDEX)\\s+[`\"]?([\\w]+)?[`\"]?\\s*\\(([^)]+)\\)",
            Pattern.CASE_INSENSITIVE
    );
    private static final Pattern KEY_DEF = Pattern.compile(
            "(?:KEY|INDEX)\\s+[`\"]?([\\w]+)?[`\"]?\\s*\\(([^)]+)\\)",
            Pattern.CASE_INSENSITIVE
    );

    public static List<TableDefinition> parseFile(Path ddlPath) {
        try {
            return parse(new String(Files.readAllBytes(ddlPath), StandardCharsets.UTF_8));
        } catch (IOException ex) {
            throw new IllegalStateException("Failed to read DDL file: " + ddlPath, ex);
        }
    }

    public static List<TableDefinition> parse(String ddlContent) {
        List<TableDefinition> tables = new ArrayList<>();
        Matcher matcher = CREATE_TABLE_START.matcher(ddlContent);
        while (matcher.find()) {
            int openParenIndex = matcher.end() - 1;
            int closeParenIndex = findMatchingCloseParen(ddlContent, openParenIndex);
            String body = ddlContent.substring(matcher.end(), closeParenIndex);
            String suffix = ddlContent.substring(closeParenIndex + 1);
            String tableComment = extractTableComment(suffix);
            tables.add(parseTable(matcher.group(1), body, tableComment));
        }
        return tables;
    }

    private static int findMatchingCloseParen(String text, int openParenIndex) {
        int depth = 0;
        for (int index = openParenIndex; index < text.length(); index++) {
            char ch = text.charAt(index);
            if (ch == '(') {
                depth++;
            } else if (ch == ')') {
                depth--;
                if (depth == 0) {
                    return index;
                }
            }
        }
        throw new IllegalArgumentException("Unclosed parenthesis in CREATE TABLE statement");
    }

    private static String extractTableComment(String suffix) {
        Matcher commentMatcher = TABLE_COMMENT.matcher(suffix);
        if (commentMatcher.find()) {
            return commentMatcher.group(1).replace("''", "'");
        }
        return "";
    }

    private static TableDefinition parseTable(String rawTableName, String body, String tableComment) {
        TableDefinition table = new TableDefinition();
        table.setTableName(stripQuotes(rawTableName));
        table.setClassName(NamingUtils.toClassName(table.getTableName()));
        table.setVariableName(NamingUtils.toVariableName(table.getTableName()));
        table.setComment(tableComment == null ? "" : tableComment);

        Map<String, ColumnDefinition> columnMap = new LinkedHashMap<>();
        List<IndexDefinition> indexes = new ArrayList<>();

        for (String part : splitDefinitions(body)) {
            String trimmed = part.trim();
            if (trimmed.isEmpty()) {
                continue;
            }

            Matcher primaryMatcher = PRIMARY_KEY_DEF.matcher(trimmed);
            if (primaryMatcher.find()) {
                IndexDefinition index = new IndexDefinition();
                index.setName("PRIMARY");
                index.setPrimary(true);
                index.setUnique(true);
                index.setColumns(parseColumnList(primaryMatcher.group(1)));
                indexes.add(index);
                continue;
            }

            Matcher uniqueMatcher = UNIQUE_KEY_DEF.matcher(trimmed);
            if (uniqueMatcher.find()) {
                IndexDefinition index = new IndexDefinition();
                index.setName(uniqueMatcher.group(1));
                index.setUnique(true);
                index.setColumns(parseColumnList(uniqueMatcher.group(2)));
                indexes.add(index);
                continue;
            }

            Matcher keyMatcher = KEY_DEF.matcher(trimmed);
            if (keyMatcher.find()) {
                IndexDefinition index = new IndexDefinition();
                index.setName(keyMatcher.group(1));
                index.setColumns(parseColumnList(keyMatcher.group(2)));
                indexes.add(index);
                continue;
            }

            Matcher columnMatcher = COLUMN_DEF.matcher(trimmed);
            if (!columnMatcher.find()) {
                continue;
            }

            ColumnDefinition column = new ColumnDefinition();
            column.setName(stripQuotes(columnMatcher.group(1)));
            column.setSqlType(columnMatcher.group(2).trim());
            String extras = columnMatcher.group(3);
            column.setPrimaryKey(PRIMARY_KEY_INLINE.matcher(extras).find());
            column.setAutoIncrement(AUTO_INCREMENT.matcher(extras).find());
            column.setNullable(!NOT_NULL.matcher(extras).find() && !column.isPrimaryKey());

            Matcher commentMatcher = COMMENT.matcher(extras);
            if (commentMatcher.find()) {
                column.setComment(commentMatcher.group(1).replace("''", "'"));
            }

            TypeMapper.applyJavaType(column);
            column.setJavaName(NamingUtils.toFieldName(column.getName()));
            columnMap.put(column.getName(), column);
        }

        for (IndexDefinition index : indexes) {
            if (index.isPrimary()) {
                for (String columnName : index.getColumns()) {
                    ColumnDefinition column = columnMap.get(columnName);
                    if (column != null) {
                        column.setPrimaryKey(true);
                        column.setNullable(false);
                    }
                }
            }
        }

        table.setColumns(new ArrayList<>(columnMap.values()));
        table.setIndexes(indexes);
        ColumnDefinition primaryKey = null;
        for (ColumnDefinition column : table.getColumns()) {
            if (column.isPrimaryKey()) {
                primaryKey = column;
                break;
            }
        }
        table.setPrimaryKey(primaryKey);
        table.setBusinessKey(BusinessKeyResolver.resolve(table, "auto"));
        return table;
    }

    private static List<String> splitDefinitions(String body) {
        List<String> parts = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int depth = 0;
        for (char ch : body.toCharArray()) {
            if (ch == '(') {
                depth++;
            } else if (ch == ')') {
                depth--;
            }
            if (ch == ',' && depth == 0) {
                parts.add(current.toString());
                current.setLength(0);
                continue;
            }
            current.append(ch);
        }
        if (current.length() > 0) {
            parts.add(current.toString());
        }
        return parts;
    }

    private static List<String> parseColumnList(String rawColumns) {
        List<String> columns = new ArrayList<>();
        for (String part : rawColumns.split(",")) {
            String column = stripQuotes(part.trim());
            int openParen = column.indexOf('(');
            if (openParen > 0) {
                column = column.substring(0, openParen).trim();
            }
            if (!column.isEmpty()) {
                columns.add(column);
            }
        }
        return columns;
    }

    private static String stripQuotes(String value) {
        String normalized = value.trim();
        if ((normalized.startsWith("`") && normalized.endsWith("`"))
                || (normalized.startsWith("\"") && normalized.endsWith("\""))) {
            return normalized.substring(1, normalized.length() - 1);
        }
        return normalized;
    }

    private DdlParser() {
    }
}
