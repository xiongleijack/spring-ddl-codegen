package com.codegen.model;

import java.util.ArrayList;
import java.util.List;

public class TableDefinition {

    private String tableName;
    private String className;
    private String variableName;
    private String comment;
    private List<ColumnDefinition> columns = new ArrayList<>();
    private List<IndexDefinition> indexes = new ArrayList<>();
    private ColumnDefinition primaryKey;
    private ColumnDefinition businessKey;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ColumnDefinition> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDefinition> columns) {
        this.columns = columns;
    }

    public List<IndexDefinition> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<IndexDefinition> indexes) {
        this.indexes = indexes;
    }

    public ColumnDefinition getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ColumnDefinition primaryKey) {
        this.primaryKey = primaryKey;
    }

    public ColumnDefinition getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(ColumnDefinition businessKey) {
        this.businessKey = businessKey;
    }
}
