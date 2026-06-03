<#-- QueryBO查询业务对象模板 - 对齐 tmpl.json 风格 -->
package ${basePackage}.model.bo;

<#list importTypes as importType>
import ${importType};
</#list>
import java.sql.Timestamp;

/**
 * ${table.comment!table.className}表查询业务对象
 *
 * @author ${author}
 */
public class ${table.className}QueryBO {

<#list table.columns as column>
<#if column.comment?? && column.comment != "">
    /**
     * ${column.comment}
     */
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
