<#--
  spiderAnnouncementDAO：公告爬虫 DAO
  - yaml: spiderAnnouncementDAO
  - 输出类名仍为 XxxDAO，与 dao 一致
  - implements SpiderAnnouncementLongPrimaryEntitySync
-->
package ${basePackage}.dao<#if databasePackage?has_content>.${databasePackage}</#if>;

import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.DynamicQueryMapper;
import ${basePackage}.mapper<#if databasePackage?has_content>.${databasePackage}</#if>.${table.className}Mapper;
import ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>.${table.className}DO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.in;
<#if spiderAnnouncementSyncClass?has_content && (databasePackage!"") != "spider">
import ${spiderAnnouncementSyncClass};
</#if>

/**
 * ${table.className}DAO（公告爬虫同步）
 *
 * @author ${author}
 */
@Repository
public class ${table.className}DAO implements SpiderAnnouncementLongPrimaryEntitySync<${table.className}DO> {

    @Resource
    private ${table.className}Mapper ${table.variableName}Mapper;

    @Override
    public DynamicQueryMapper<${table.className}DO> getEntityMapper() {
        return ${table.variableName}Mapper;
    }

    @Override
    public Class<${table.className}DO> getEntityClass() {
        return ${table.className}DO.class;
    }

    /**
     * 根据主键批量查询
     *
     * @param dataIds 爬虫表主键
     * @return DO 列表
     */
    public List<${table.className}DO> listByIds(Collection<Long> dataIds) {
        if (CollectionUtils.isEmpty(dataIds)) {
            return Collections.emptyList();
        }
        DynamicQuery<${table.className}DO> query = DynamicQuery.createQuery(${table.className}DO.class)
                .and(${table.className}DO::getId, in(dataIds));
        return ${table.variableName}Mapper.selectByDynamicQuery(query);
    }
}
