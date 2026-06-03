<#-- Mapper接口模板 - 对齐 tmpl.json 风格，extends DynamicQueryMapper -->
package ${basePackage}.mapper;

import com.github.wz2cool.dynamic.mybatis.mapper.DynamicQueryMapper;
import ${basePackage}.model.entity.${table.className}DO;

/**
 * ${table.comment!table.className}表DynamicQueryMapper层 {@link ${table.className}DO}
 *
 * @author ${author}
 */
public interface ${table.className}Mapper extends DynamicQueryMapper<${table.className}DO> {

}
