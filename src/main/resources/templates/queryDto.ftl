<#-- ============================================================
     QueryDTO查询请求对象模板
     生成 {ClassName}QueryDTO.java，用于分页/列表查询的请求参数。
     排除主键和审计字段，仅保留业务查询条件字段。
     ============================================================ -->
package ${basePackage}.api.dto;

<#if config.stack.lombok>
import lombok.Data;
</#if>
<#if config.stack.swagger>
import io.swagger.v3.oas.annotations.media.Schema;
</#if>
<#list importTypes as importType>
import ${importType};
</#list>

/**
 * ${table.comment!table.className}表查询请求对象
 *
 * @author ${author}
 */
<#if config.stack.lombok>
@Data
</#if>
public class ${table.className}QueryDTO {

<#list table.columns as column>
<#if !column.primaryKey && !util.isAuditField(column.javaName)>
<#if config.stack.swagger>
    @Schema(description = "${column.comment!column.name}")
</#if>
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
