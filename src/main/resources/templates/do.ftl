<#-- DO实体类模板 - 对齐 tmpl.json 风格，使用JPA注解 -->
package ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>;

import javax.persistence.*;
import java.sql.Timestamp;
<#list importTypes as importType>
import ${importType};
</#list>

/**
 * ${table.comment!table.className}表实体对象
 *
 * @author ${author}
 */
@Table(name="${table.tableName}")
public class ${table.className}DO {

<#list table.columns as column>
<#if column.comment?? && column.comment != "">
    /**
     * ${column.comment}
     */
</#if>
<#if column.primaryKey>
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
<#else>
    @Column
</#if>
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#list>
<#list table.columns as column>
    public ${util.simpleType(column.javaType)} get${util.firstUpper(column.javaName)}() {
        return ${column.javaName};
    }

    public void set${util.firstUpper(column.javaName)}(${util.simpleType(column.javaType)} ${column.javaName}) {
        this.${column.javaName} = ${column.javaName};
    }

</#list>
}
