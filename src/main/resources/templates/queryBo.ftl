<#-- ============================================================
     QueryBO查询业务对象模板
     生成 {ClassName}QueryBO.java，Service/DAO层内部使用的查询条件对象。
     与QueryDTO字段一致，用于Service层与DAO层之间传递查询参数，
     实现API层(DTO)与数据层(BO)的解耦。
     ============================================================ -->
package ${basePackage}.domain.bo;

<#if config.stack.lombok>
import lombok.Data;
</#if>
<#list importTypes as importType>
import ${importType};
</#list>

/**
 * ${table.comment!table.className}表查询业务对象
 *
 * @author ${author}
 */
<#if config.stack.lombok>
@Data
</#if>
public class ${table.className}QueryBO {

<#list table.columns as column>
<#if !column.primaryKey && !util.isAuditField(column.javaName)>
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#if>
</#list>
<#if !config.stack.lombok>
<#list table.columns as column>
<#if !column.primaryKey && !util.isAuditField(column.javaName)>
    public ${util.simpleType(column.javaType)} get${util.firstUpper(column.javaName)}() {
        return ${column.javaName};
    }

    public void set${util.firstUpper(column.javaName)}(${util.simpleType(column.javaType)} ${column.javaName}) {
        this.${column.javaName} = ${column.javaName};
    }

</#if>
</#list>
</#if>
}
