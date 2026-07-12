<#-- 分组 DO 模板 - 对齐业务项目 GroupDO 风格，支持分组键与聚合表达式 -->
package ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>.group;

import javax.persistence.Column;
<#list importTypes as importType>
import ${importType};
</#list>

/**
 * ${groupDo.comment!groupDo.className}
 *
 * @author ${author}
 */
public class ${groupDo.className} {

<#list groupDo.fields as field>
<#if field.comment?? && field.comment != "">
    /**
     * ${field.comment}
     */
</#if>
<#if field.column?? && field.column != "">
    @Column(name = "${field.column}")
<#else>
    @Column
</#if>
    private ${util.simpleType(field.type)} ${field.name};

</#list>
<#list groupDo.fields as field>
<#if util.isSqlDate(field.type)>
    public ${util.simpleType(field.type)} get${util.firstUpper(field.name)}() {
        return ${field.name} == null ? null : new ${util.simpleType(field.type)}(${field.name}.getTime());
    }

    public void set${util.firstUpper(field.name)}(${util.simpleType(field.type)} ${field.name}) {
        this.${field.name} = ${field.name} == null ? null : new ${util.simpleType(field.type)}(${field.name}.getTime());
    }

<#else>
    public ${util.simpleType(field.type)} get${util.firstUpper(field.name)}() {
        return ${field.name};
    }

    public void set${util.firstUpper(field.name)}(${util.simpleType(field.type)} ${field.name}) {
        this.${field.name} = ${field.name};
    }

</#if>
</#list>
}
