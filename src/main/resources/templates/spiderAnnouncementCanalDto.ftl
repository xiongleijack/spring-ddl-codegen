<#--
  spiderAnnouncementCanalDTO：公告爬虫 CanalDTO
  - yaml: spiderAnnouncementCanalDTO
  - 输出类名仍为 XxxCanalDTO，与 canalDTO 一致
-->
package ${basePackage}.model.dto.canal;

<#list importTypes as importType>
import ${importType};
</#list>
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
<#if spiderNeedsTimestampImport!false>
import java.sql.Timestamp;
</#if>
<#if spiderNeedsObjectsImport!false>
import java.util.Objects;
</#if>
<#if spiderAnnouncementEntityClass?has_content>
import ${spiderAnnouncementEntityClass};
</#if>

/**
 * ${table.comment!table.className}表 CanalDTO
 * <p>
 * 实现 SpiderAnnouncementEntity；无对应列的契约方法为 stub。
 *
 * @author ${author}
 */
public class ${table.className}CanalDTO implements SpiderAnnouncementEntity {

<#list table.columns as column>
<#if column.comment?? && column.comment != "">
    /**
     * ${column.comment}
     */
</#if>
    @JsonProperty("${util.humpToUnderline(column.javaName)}")
<#if util.simpleType(column.javaType) == "Timestamp">
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
</#if>
<#if util.simpleType(column.javaType) == "Date">
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
</#if>
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#list>
<#list table.columns as column>
<#assign simpleType = util.simpleType(column.javaType)>
<#assign isContractField = spiderContractFieldNames?seq_contains(column.javaName)>
<#assign overrideIdTime = (column.javaName == "id" || column.javaName == "createTime" || column.javaName == "updateTime")>
<#if !isContractField>
<#if overrideIdTime>
    @Override
</#if>
    public ${simpleType} get${util.firstUpper(column.javaName)}() {
<#if (column.javaName == "createTime" || column.javaName == "updateTime") && simpleType == "Timestamp">
        return Objects.isNull(${column.javaName}) ? null : new Timestamp(${column.javaName}.getTime());
<#else>
        return ${column.javaName};
</#if>
    }

</#if>
<#if column.javaName == "bulletinTitle" || column.javaName == "attachmentTitle">
    @Override
</#if>
    public void set${util.firstUpper(column.javaName)}(${simpleType} ${column.javaName}) {
<#if (column.javaName == "createTime" || column.javaName == "updateTime") && simpleType == "Timestamp">
        this.${column.javaName} = Objects.isNull(${column.javaName}) ? null : new Timestamp(${column.javaName}.getTime());
<#else>
        this.${column.javaName} = ${column.javaName};
</#if>
    }

</#list>
<#list spiderContractMethods as m>
    @Override
<#if m.kind == "getter">
    public ${m.returnType} ${m.methodName}() {
<#if m.mode == "delegate">
        return ${m.fieldName};
<#elseif m.mode == "timestampCopy">
        return Objects.isNull(${m.fieldName}) ? null : new Timestamp(${m.fieldName}.getTime());
<#elseif m.mode == "dateToTimestamp">
        return Objects.isNull(${m.fieldName}) ? null : new Timestamp(${m.fieldName}.getTime());
<#else>
        return null;
</#if>
    }
<#else>
    public void ${m.methodName}(${m.paramType} ${m.paramName}) {
<#if m.mode == "assign">
        this.${m.fieldName} = ${m.paramName};
<#else>
        // 表无对应列；流水线可能回写清洗后的标题
</#if>
    }
</#if>

</#list>
}
