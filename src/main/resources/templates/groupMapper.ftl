<#-- GroupMapper 模板 - SelectByGroupedQueryMapper<源DO, GroupDO> -->
package ${basePackage}.mapper<#if databasePackage?has_content>.${databasePackage}</#if>.group;

import com.github.wz2cool.dynamic.mybatis.mapper.SelectByGroupedQueryMapper;
import ${sourceDoFullName};
import ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>.group.${groupDo.className};
import org.apache.ibatis.annotations.Mapper;

/**
 * ${groupDo.comment!groupDo.className} GroupMapper
 *
 * @author ${author}
 */
@Mapper
public interface ${mapperClassName} extends SelectByGroupedQueryMapper<${sourceDoSimpleName}, ${groupDo.className}> {
}
