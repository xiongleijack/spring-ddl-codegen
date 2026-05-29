<#-- ============================================================
     DAO数据访问层模板
     生成 {ClassName}DAO.java，封装Mapper的基础操作。
     提供: 按主键查询、按业务主键查询(可选)、分页查询、
           条件列表查询、新增、更新、删除、批量新增。
     内部通过 buildWrapper() 构建动态查询条件。
     ============================================================ -->
package ${basePackage}.infrastructure.dao;

import ${basePackage}.domain.entity.${table.className}DO;
import ${basePackage}.domain.bo.${table.className}QueryBO;
import ${basePackage}.infrastructure.mapper.${table.className}Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * ${table.comment!table.className}表数据库访问层
 *
 * @author ${author}
 */
@Repository
public class ${table.className}DAO {

    @Resource
    private ${table.className}Mapper ${table.variableName}Mapper;

    /**
     * 根据主键查询
     */
    public Optional<${table.className}DO> getById(${util.simpleType(pk.javaType)} id) {
        return Optional.ofNullable(${table.variableName}Mapper.selectById(id));
    }
<#if hasBusinessKey>

    /**
     * 根据业务主键查询
     */
    public ${table.className}DO getBy${util.firstUpper(businessKey.javaName)}(${util.simpleType(businessKey.javaType)} ${businessKey.javaName}) {
        return ${table.variableName}Mapper.selectBy${util.firstUpper(businessKey.javaName)}(${businessKey.javaName});
    }
</#if>

    /**
     * 分页查询，根据QueryBO中的非空字段构建查询条件
     */
    public Page<${table.className}DO> pageQuery(Page<${table.className}DO> page, ${table.className}QueryBO queryBO) {
        LambdaQueryWrapper<${table.className}DO> wrapper = buildWrapper(queryBO);
        return ${table.variableName}Mapper.selectPage(page, wrapper);
    }

    /**
     * 条件列表查询（不分页）
     */
    public List<${table.className}DO> listByCondition(${table.className}QueryBO queryBO) {
        return ${table.variableName}Mapper.selectList(buildWrapper(queryBO));
    }

    /**
     * 新增单条记录
     */
    public int insert(${table.className}DO entity) {
        return ${table.variableName}Mapper.insert(entity);
    }

    /**
     * 根据主键更新
     */
    public int updateById(${table.className}DO entity) {
        return ${table.variableName}Mapper.updateById(entity);
    }

    /**
     * 根据主键删除
     */
    public int deleteById(${util.simpleType(pk.javaType)} id) {
        return ${table.variableName}Mapper.deleteById(id);
    }

    /**
     * 批量新增（逐条插入）
     */
    public int insertBatch(List<${table.className}DO> entities) {
        int count = 0;
        for (${table.className}DO entity : entities) {
            count += ${table.variableName}Mapper.insert(entity);
        }
        return count;
    }

    /**
     * 根据QueryBO中的非空字段动态构建LambdaQueryWrapper查询条件。
     * 仅对非主键、非审计字段进行条件拼装。
     */
    private LambdaQueryWrapper<${table.className}DO> buildWrapper(${table.className}QueryBO queryBO) {
        LambdaQueryWrapper<${table.className}DO> wrapper = new LambdaQueryWrapper<>();
        if (queryBO == null) {
            return wrapper;
        }
<#list table.columns as column>
<#if !column.primaryKey && !util.isAuditField(column.javaName)>
<#if column.javaType == "String">
        if (StringUtils.hasText(queryBO.get${util.firstUpper(column.javaName)}())) {
            wrapper.eq(${table.className}DO::get${util.firstUpper(column.javaName)}, queryBO.get${util.firstUpper(column.javaName)}());
        }
<#elseif column.javaType == "Integer" || column.javaType == "Long" || column.javaType == "Boolean">
        if (queryBO.get${util.firstUpper(column.javaName)}() != null) {
            wrapper.eq(${table.className}DO::get${util.firstUpper(column.javaName)}, queryBO.get${util.firstUpper(column.javaName)}());
        }
</#if>
</#if>
</#list>
        return wrapper;
    }
}
