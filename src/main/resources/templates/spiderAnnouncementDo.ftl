<#--
  spiderAnnouncementDO：公告爬虫 DO
  - yaml: spiderAnnouncementDO（类名仍为 XxxDO，与 do 一致）
  - implements SpiderAnnouncementEntity
-->
package ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
<#list importTypes as importType>
import ${importType};
</#list>
<#if spiderNeedsTimestampImport!false>
import java.sql.Timestamp;
</#if>
<#if spiderNeedsObjectsImport!false>
import java.util.Objects;
</#if>
<#if spiderAnnouncementEntityClass?has_content && (databasePackage!"") != "spider">
import ${spiderAnnouncementEntityClass};
</#if>

/**
 * ${table.comment!table.className}表实体对象
 * <p>
 * 实现 SpiderAnnouncementEntity；无对应列的契约方法为 stub（return null），可按 mapping 再 override。
 *
 * @author ${author}
 */
@Table(name = "${table.tableName}")
public class ${table.className}DO implements SpiderAnnouncementEntity {

<#list table.columns as column>
<#if column.comment?? && column.comment != "">
    /**
     * ${column.comment}
     */
</#if>
<#if column.primaryKey>
    @Id
<#if column.autoIncrement!false>
    @GeneratedValue(strategy = GenerationType.IDENTITY)
</#if>
    @Column
<#else>
    @Column
</#if>
    private ${util.simpleType(column.javaType)} ${column.javaName};

</#list>
<#-- 非契约字段：完整 getter/setter；契约字段：仅 setter（getter 由契约方法提供，避免 Date/Timestamp 冲突） -->
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
<#-- SpiderAnnouncementEntity 契约方法 -->
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
