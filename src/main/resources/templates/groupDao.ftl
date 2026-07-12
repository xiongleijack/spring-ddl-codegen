<#-- GroupDAO 模板：1) 按分组键列表查 GroupDO  2) 按 GroupDO 列表反查源表 DO -->
package ${basePackage}.dao<#if databasePackage?has_content>.${databasePackage}</#if>.group;

import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.GroupByQuery;
import com.github.wz2cool.dynamic.GroupedQuery;
import ${basePackage}.mapper<#if databasePackage?has_content>.${databasePackage}</#if>.${sourceMapperClassName};
import ${basePackage}.mapper<#if databasePackage?has_content>.${databasePackage}</#if>.group.${mapperClassName};
import ${sourceDoFullName};
import ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>.group.${groupDo.className};
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;

/**
 * ${groupDo.comment!groupDo.className} 分组数据访问层
 *
 * @author ${author}
 */
@Repository
public class ${daoClassName} {

    @Resource
    private ${mapperClassName} ${mapperVarName};

    @Resource
    private ${sourceMapperClassName} ${sourceMapperVarName};

    /**
     * 根据${primaryGroupKey.comment!primaryGroupKey.name}列表分组查询
     *
     * @param ${primaryGroupKey.name}s ${primaryGroupKey.comment!primaryGroupKey.name}列表
     * @return {@link ${groupDo.className}} 集合
     */
    public List<${groupDo.className}> listGroupBy${util.firstUpper(primaryGroupKey.name)}s(
            Collection<${util.simpleType(primaryGroupKey.type)}> ${primaryGroupKey.name}s) {
        if (CollectionUtils.isEmpty(${primaryGroupKey.name}s)) {
            return Collections.emptyList();
        }
        GroupedQuery<${sourceDoSimpleName}, ${groupDo.className}> groupedQuery =
                GroupByQuery.createQuery(${sourceDoSimpleName}.class, ${groupDo.className}.class)
                        .and(${sourceDoSimpleName}::get${util.firstUpper(primaryGroupKey.resolveSourceJavaName())},
                                c -> c.in(${primaryGroupKey.name}s))
<#if hasValidFilter>
                        .and(${sourceDoSimpleName}::get${util.firstUpper(validFilter.field)}, isEqual(${validFilterLiteral}))
</#if>
                        .groupBy(<#list groupKeys as key>${sourceDoSimpleName}::get${util.firstUpper(key.resolveSourceJavaName())}<#if key_has_next>, </#if></#list>);
        return ${mapperVarName}.selectByGroupedQuery(groupedQuery);
    }

    /**
     * 根据分组结果反查源表记录
     *
     * @param groupDos {@link ${groupDo.className}} 列表
     * @return {@link ${sourceDoSimpleName}} 集合
     */
    public List<${sourceDoSimpleName}> listByGroupDos(Collection<${groupDo.className}> groupDos) {
        if (CollectionUtils.isEmpty(groupDos)) {
            return Collections.emptyList();
        }
        DynamicQuery<${sourceDoSimpleName}> dynamicQuery = DynamicQuery.createQuery(${sourceDoSimpleName}.class);
        for (${groupDo.className} groupDO : groupDos) {
            dynamicQuery.or(g ->
                    g<#list matchFields as field>
                            .and(${sourceDoSimpleName}::get${util.firstUpper(field.resolveSourceJavaName())},
                                    isEqual(groupDO.get${util.firstUpper(field.name)}()))</#list>
            );
        }
<#if hasValidFilter>
        dynamicQuery.and(${sourceDoSimpleName}::get${util.firstUpper(validFilter.field)}, isEqual(${validFilterLiteral}));
</#if>
        return ${sourceMapperVarName}.selectByDynamicQuery(dynamicQuery);
    }
}
