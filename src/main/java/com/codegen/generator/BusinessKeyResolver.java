package com.codegen.generator;

import com.codegen.model.ColumnDefinition;
import com.codegen.model.IndexDefinition;
import com.codegen.model.TableDefinition;

import java.util.Locale;
import java.util.Optional;

public final class BusinessKeyResolver {

    public static ColumnDefinition resolve(TableDefinition table, String businessKeyOption) {
        if (businessKeyOption == null || businessKeyOption.trim().isEmpty()) {
            return null;
        }

        String option = businessKeyOption.trim();
        if ("none".equalsIgnoreCase(option)) {
            return null;
        }
        if (!"auto".equalsIgnoreCase(option)) {
            return findColumn(table, option);
        }

        Optional<IndexDefinition> uniqueIndex = table.getIndexes().stream()
                .filter(index -> index.isUnique() && !index.isPrimary())
                .filter(index -> index.getColumns().size() == 1)
                .findFirst();

        if (!uniqueIndex.isPresent()) {
            return null;
        }

        String columnName = uniqueIndex.get().getColumns().get(0);
        ColumnDefinition column = findColumn(table, columnName);
        if (column != null && column.isPrimaryKey()) {
            return null;
        }
        return column;
    }

    private static ColumnDefinition findColumn(TableDefinition table, String name) {
        String normalized = name.trim();
        for (ColumnDefinition column : table.getColumns()) {
            if (column.getName().equalsIgnoreCase(normalized)
                    || column.getJavaName().equalsIgnoreCase(normalized)) {
                return column;
            }
        }
        return null;
    }

    private BusinessKeyResolver() {
    }
}
