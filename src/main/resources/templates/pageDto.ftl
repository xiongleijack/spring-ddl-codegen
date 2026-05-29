<#-- ============================================================
     PageDTO分页响应对象模板
     生成 {ClassName}PageDTO.java，用于分页查询的响应数据。
     包含业务字段 + 额外的updateTime展示字段。
     排除审计字段中的创建人/更新人等内部字段。
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
 * ${table.comment!table.className}表分页响应对象
 *
 * @author ${author}
 */
<#if config.stack.lombok>
@Data
</#if>
public class ${table.className}PageDTO {

<#list table.columns as column>
<#if !util.isAuditField(column.javaName)>
<#if config.stack.swagger>
    @Schema(description = "${column.comment!column.name}")
</#if>
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#if>
</#list>
<#if config.stack.swagger>
    @Schema(description = "更新时间")
</#if>
    private String updateTime;

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
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
</#if>
}
