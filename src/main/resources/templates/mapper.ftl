<#-- ============================================================
     Mapper接口模板
     生成 {ClassName}Mapper.java，继承MyBatis-Plus的BaseMapper。
     提供基础CRUD能力，如有业务主键则额外生成按业务主键查询方法。
     ============================================================ -->
package ${basePackage}.infrastructure.mapper;

import ${basePackage}.domain.entity.${table.className}DO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
<#if hasBusinessKey>
import org.apache.ibatis.annotations.Param;
</#if>

/**
 * ${table.comment!table.className}表Mapper层
 *
 * @author ${author}
 */
@Mapper
public interface ${table.className}Mapper extends BaseMapper<${table.className}DO> {
<#-- 如果表存在业务主键（唯一索引），生成按业务主键查询的方法 -->
<#if hasBusinessKey>

    ${table.className}DO selectBy${util.firstUpper(businessKey.javaName)}(@Param("${businessKey.javaName}") ${util.simpleType(businessKey.javaType)} ${businessKey.javaName});
</#if>
}
