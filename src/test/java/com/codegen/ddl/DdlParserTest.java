package com.codegen.ddl;

import com.codegen.model.ColumnDefinition;
import com.codegen.model.TableDefinition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DdlParserTest {

    @Test
    void parsesTablePrimaryKeyAndBusinessKey() {
        String ddl = "CREATE TABLE `t_order` (\n"
                + "  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',\n"
                + "  `order_no` varchar(32) NOT NULL COMMENT '订单号',\n"
                + "  `amount` decimal(10, 2) NOT NULL COMMENT '订单金额',\n"
                + "  PRIMARY KEY (`id`),\n"
                + "  UNIQUE KEY `uk_order_no` (`order_no`)\n"
                + ") ENGINE=InnoDB COMMENT='订单表';";

        List<TableDefinition> tables = DdlParser.parse(ddl);
        assertEquals(1, tables.size());

        TableDefinition table = tables.get(0);
        assertEquals("t_order", table.getTableName());
        assertEquals("Order", table.getClassName());
        assertNotNull(table.getPrimaryKey());
        assertEquals("id", table.getPrimaryKey().getName());
        assertNotNull(table.getBusinessKey());
        assertEquals("order_no", table.getBusinessKey().getName());

        ColumnDefinition amount = null;
        for (ColumnDefinition column : table.getColumns()) {
            if ("amount".equals(column.getName())) {
                amount = column;
                break;
            }
        }
        assertNotNull(amount);
        assertEquals("java.math.BigDecimal", amount.getJavaType());
    }
}
