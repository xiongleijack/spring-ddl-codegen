<#-- ============================================================
     DetailDTO详情对象模板
     生成 {ClassName}DetailDTO.java，用于新增/更新/详情查询的数据传输。
     包含除审计字段(createBy/createTime/updateBy/updateTime/deleted)外的所有字段。
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
 * ${table.comment!table.className}表详情对象
 *
 * @author ${author}
 */
<#if config.stack.lombok>
@Data
</#if>
public class ${table.className}DetailDTO {

<#list table.columns as column>
<#if !util.isAuditField(column.javaName)>
<#if config.stack.swagger>
    @Schema(description = "${column.comment!column.name}")
</#if>
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#if>
</#list>
<#if !config.stack.lombok>
<#list table.columns as column>
<#if !util.isAuditField(column.javaName)>
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
