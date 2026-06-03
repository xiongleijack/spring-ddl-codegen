package com.codegen.ddl;

import com.codegen.config.ProjectConfig;
import com.codegen.generator.BusinessKeyResolver;
import com.codegen.generator.NamingUtils;
import com.codegen.generator.TypeMapper;
import com.codegen.model.ColumnDefinition;
import com.codegen.model.IndexDefinition;
import com.codegen.model.TableDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.*;

/**
 * 通过JDBC连接MySQL数据库，从INFORMATION_SCHEMA读取表元数据，
 * 生成与DdlParser相同结构的TableDefinition列表。
 *
 * @author codegen
 */
public final class JdbcMetadataReader {

    private static final Logger log = LoggerFactory.getLogger(JdbcMetadataReader.class);

    private final String url;
    private final String username;
    private final String password;
    private final List<String> tableFilter;

    /**
     * @param datasource YAML中配置的数据源信息
     */
    public JdbcMetadataReader(ProjectConfig.DatasourceSection datasource) {
        this.url = datasource.getUrl();
        this.username = datasource.getUsername();
        this.password = datasource.getPassword();
        this.tableFilter = datasource.getTables();
    }

    /**
     * 连接数据库读取表元数据，返回TableDefinition列表。
     *
     * @return 表定义列表
     */
    public List<TableDefinition> readTables() {
        String schema = extractSchema(url);
        log.info("通过JDBC读取数据库元数据, schema: {}", schema);

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            List<String[]> tableInfos = queryTables(conn, schema);
            List<TableDefinition> tables = new ArrayList<>();
            for (int i = 0; i < tableInfos.size(); i++) {
                String[] info = tableInfos.get(i);
                log.info("处理进度: {}/{}, table: {}", i + 1, tableInfos.size(), info[0]);
                tables.add(buildTable(conn, schema, info[0], info[1]));
            }
            return tables;
        } catch (SQLException e) {
            throw new IllegalStateException("读取数据库元数据失败: " + url, e);
        }
    }

    /**
     * 查询schema下的表名和表注释。
     */
    private List<String[]> queryTables(Connection conn, String schema) throws SQLException {
        StringBuilder sql = new StringBuilder(
                "SELECT TABLE_NAME, TABLE_COMMENT FROM INFORMATION_SCHEMA.TABLES"
                        + " WHERE TABLE_SCHEMA = ? AND TABLE_TYPE = 'BASE TABLE'");
        boolean hasFilter = tableFilter != null && !tableFilter.isEmpty();
        if (hasFilter) {
            sql.append(" AND TABLE_NAME IN (");
            for (int i = 0; i < tableFilter.size(); i++) {
                sql.append(i == 0 ? "?" : ",?");
            }
            sql.append(")");
        }
        sql.append(" ORDER BY TABLE_NAME");

        List<String[]> result = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            ps.setString(1, schema);
            if (hasFilter) {
                for (int i = 0; i < tableFilter.size(); i++) {
                    ps.setString(i + 2, tableFilter.get(i));
                }
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(new String[]{rs.getString("TABLE_NAME"), rs.getString("TABLE_COMMENT")});
                }
            }
        }
        return result;
    }

    /**
     * 构建单张表的完整TableDefinition。
     */
    private TableDefinition buildTable(Connection conn, String schema,
                                       String tableName, String tableComment) throws SQLException {
        TableDefinition table = new TableDefinition();
        table.setTableName(tableName);
        table.setClassName(NamingUtils.toClassName(tableName));
        table.setVariableName(NamingUtils.toVariableName(tableName));
        table.setComment(tableComment != null ? tableComment : "");

        List<ColumnDefinition> columns = queryColumns(conn, schema, tableName);
        table.setColumns(columns);

        List<IndexDefinition> indexes = queryIndexes(conn, schema, tableName);
        table.setIndexes(indexes);

        ColumnDefinition pk = null;
        for (ColumnDefinition col : columns) {
            if (col.isPrimaryKey()) {
                pk = col;
                break;
            }
        }
        table.setPrimaryKey(pk);
        table.setBusinessKey(BusinessKeyResolver.resolve(table, "auto"));
        return table;
    }

    /**
     * 查询表的列定义。
     */
    private List<ColumnDefinition> queryColumns(Connection conn, String schema,
                                                String tableName) throws SQLException {
        String sql = "SELECT COLUMN_NAME, COLUMN_TYPE, IS_NULLABLE, COLUMN_KEY, EXTRA, COLUMN_COMMENT"
                + " FROM INFORMATION_SCHEMA.COLUMNS"
                + " WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?"
                + " ORDER BY ORDINAL_POSITION";

        List<ColumnDefinition> columns = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schema);
            ps.setString(2, tableName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ColumnDefinition col = new ColumnDefinition();
                    col.setName(rs.getString("COLUMN_NAME"));
                    col.setSqlType(rs.getString("COLUMN_TYPE"));
                    col.setNullable("YES".equals(rs.getString("IS_NULLABLE")));
                    col.setPrimaryKey("PRI".equals(rs.getString("COLUMN_KEY")));
                    String extra = rs.getString("EXTRA");
                    col.setAutoIncrement(extra != null && extra.toLowerCase().contains("auto_increment"));
                    col.setComment(rs.getString("COLUMN_COMMENT"));
                    TypeMapper.applyJavaType(col);
                    col.setJavaName(NamingUtils.toFieldName(col.getName()));
                    columns.add(col);
                }
            }
        }
        return columns;
    }

    /**
     * 查询表的索引信息。
     */
    private List<IndexDefinition> queryIndexes(Connection conn, String schema,
                                               String tableName) throws SQLException {
        String sql = "SELECT INDEX_NAME, NON_UNIQUE, COLUMN_NAME, SEQ_IN_INDEX"
                + " FROM INFORMATION_SCHEMA.STATISTICS"
                + " WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?"
                + " ORDER BY INDEX_NAME, SEQ_IN_INDEX";

        Map<String, IndexDefinition> indexMap = new LinkedHashMap<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schema);
            ps.setString(2, tableName);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String indexName = rs.getString("INDEX_NAME");
                    boolean nonUnique = rs.getInt("NON_UNIQUE") == 1;
                    String columnName = rs.getString("COLUMN_NAME");

                    IndexDefinition index = indexMap.get(indexName);
                    if (index == null) {
                        index = new IndexDefinition();
                        index.setName(indexName);
                        index.setPrimary("PRIMARY".equals(indexName));
                        index.setUnique(!nonUnique);
                        index.setColumns(new ArrayList<String>());
                        indexMap.put(indexName, index);
                    }
                    index.getColumns().add(columnName);
                }
            }
        }
        return new ArrayList<>(indexMap.values());
    }

    /**
     * 从JDBC URL中解析schema名称。
     * 例如 jdbc:mysql://host:3306/my_db?params -> my_db
     */
    private static String extractSchema(String jdbcUrl) {
        String withoutParams = jdbcUrl.contains("?")
                ? jdbcUrl.substring(0, jdbcUrl.indexOf('?'))
                : jdbcUrl;
        int lastSlash = withoutParams.lastIndexOf('/');
        if (lastSlash < 0 || lastSlash == withoutParams.length() - 1) {
            throw new IllegalArgumentException("无法从JDBC URL中解析schema: " + jdbcUrl);
        }
        return withoutParams.substring(lastSlash + 1);
    }

    private JdbcMetadataReader() {
        this.url = null;
        this.username = null;
        this.password = null;
        this.tableFilter = null;
    }
}