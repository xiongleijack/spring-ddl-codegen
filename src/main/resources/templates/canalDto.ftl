<#-- CanalDTO对象模板 - Canal binlog同步用 -->
package ${basePackage}.model.dto.canal;

<#list importTypes as importType>
import ${importType};
</#list>
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ${table.comment!table.className}表CanalDTO对象
 *
 * @author ${author}
 */
public class ${table.className}CanalDTO {

<#list table.columns as column>
<#if column.comment?? && column.comment != "">
    /**
     * ${column.comment}
     */
</#if>
    @JsonProperty("${util.humpToUnderline(column.javaName)}")
<#if util.simpleType(column.javaType) == "Timestamp">
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
</#if>
<#if util.simpleType(column.javaType) == "Date">
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
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
