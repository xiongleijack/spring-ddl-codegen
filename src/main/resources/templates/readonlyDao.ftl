<#-- 只读 DAO 模板 - 无写操作、无事务、无分页，仅按 id 批量查询 -->
package ${basePackage}.dao<#if databasePackage?has_content>.${databasePackage}</#if>;

import com.github.wz2cool.dynamic.DynamicQuery;
import ${basePackage}.mapper<#if databasePackage?has_content>.${databasePackage}</#if>.${table.className}Mapper;
import ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>.${table.className}DO;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;

import org.apache.ibatis.session.RowBounds;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.github.wz2cool.dynamic.builder.direction.SortDirections.asc;

/**
 * ${table.comment!table.className}表只读数据访问层 {@link ${table.className}DO}
 * 对${table.className}Mapper层做出简单封装 {@link ${table.className}Mapper}
 *
 * @author ${author}
 */
@Repository
public class ${table.className}DAO {

    @Resource
    private ${table.className}Mapper ${table.variableName}Mapper;

    /**
     * 根据 id 列表查询${table.comment!table.className}
     *
     * @param ids 主键 id 列表
     * @return {@link ${table.className}DO} 集合
     */
    public List<${table.className}DO> listByIds(Collection<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Collections.emptyList();
        }
        DynamicQuery<${table.className}DO> dynamicQuery = DynamicQuery.createQuery(${table.className}DO.class)
                .and(${table.className}DO::getId, c -> c.in(ids));
        return ${table.variableName}Mapper.selectByDynamicQuery(dynamicQuery);
    }

    /**
     * 分批获取${table.comment!table.className}数据
     *
     * @param startId    起始 id（不包含）
     * @param fetchCount 每批获取数量
     * @return {@link ${table.className}DO} 集合
     */
    public List<${table.className}DO> listByBatch(Long startId, int fetchCount) {
        DynamicQuery<${table.className}DO> query = DynamicQuery.createQuery(${table.className}DO.class)
                .and(${table.className}DO::getId, p -> p.greaterThan(startId))
                .orderBy(${table.className}DO::getId, asc());
        return ${table.variableName}Mapper.selectRowBoundsByDynamicQuery(query, new RowBounds(0, fetchCount));
    }
}
