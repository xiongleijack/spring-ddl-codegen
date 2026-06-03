<#-- QueryDTO查询请求对象模板 - 对齐 tmpl.json 风格 -->
package ${basePackage}.model.dto.request;

<#list importTypes as importType>
import ${importType};
</#list>
import io.swagger.annotations.ApiModelProperty;

/**
 * ${table.comment!table.className}表Query对象 {@link ${table.className}DO}
 *
 * @author ${author}
 */
public class ${table.className}QueryDTO {

<#list table.columns as column>
<#if !column.primaryKey && !util.isAuditField(column.javaName)>
    @ApiModelProperty("${column.comment!column.name}")
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#if>
</#list>
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
}
