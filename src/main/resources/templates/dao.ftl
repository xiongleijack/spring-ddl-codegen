<#-- DAO数据访问层模板 - 对齐 tmpl.json 风格 -->
package ${basePackage}.dao<#if databasePackage?has_content>.${databasePackage}</#if>;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.UpdateQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.batch.MapperBatchAction;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import ${basePackage}.mapper<#if databasePackage?has_content>.${databasePackage}</#if>.${table.className}Mapper;
import ${basePackage}.model.entity<#if databasePackage?has_content>.${databasePackage}</#if>.${table.className}DO;
import ${basePackage}.model.bo.${table.className}QueryBO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ${table.comment!table.className}表数据库访问层 {@link ${table.className}DO}
 * 对${table.className}Mapper层做出简单封装 {@link ${table.className}Mapper}
 *
 * @author ${author}
 */
@Repository
public class ${table.className}DAO {

    @Resource
    private ${table.className}Mapper ${table.variableName}Mapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 幂等保存${table.comment!table.className} ${table.variableName}DOs
     *
     * @param userId       {@code Long} 用户id
     * @param ${table.variableName}DOs {@link ${table.className}DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveBatch${table.className}DOs(Long userId, final Collection<${table.className}DO> ${table.variableName}DOs) {
        if (CollectionUtils.isEmpty(${table.variableName}DOs)) {
            return;
        }
        Map<String, Long> businessKeyToIdMap = getBusinessKeyToIdMap(${table.variableName}DOs);
        List<${table.className}DO> insertList = Lists.newArrayListWithExpectedSize(${table.variableName}DOs.size());
        List<${table.className}DO> updateList = Lists.newArrayListWithExpectedSize(${table.variableName}DOs.size());
        for (${table.className}DO ${table.variableName}DO : ${table.variableName}DOs) {
            Long oldId = businessKeyToIdMap.get(getBusinessKey(${table.variableName}DO));
            if (Objects.isNull(oldId)) {
                insertList.add(${table.variableName}DO);
            } else {
                ${table.variableName}DO.setId(oldId);
                updateList.add(${table.variableName}DO);
            }
        }
        insertBatch${table.className}DOs(userId, insertList);
        updateBatch${table.className}DOsByPrimaryKey(userId, updateList);
    }

    /**
     * 批量新增${table.comment!table.className}
     *
     * @param userId       {@code Long} 用户id
     * @param ${table.variableName}DOs {@link ${table.className}DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBatch${table.className}DOs(Long userId, final List<${table.className}DO> ${table.variableName}DOs) {
        if (CollectionUtils.isEmpty(${table.variableName}DOs)) {
            return;
        }
        final MapperBatchAction<${table.className}Mapper> insertBatchAction = MapperBatchAction
                .create(${table.className}Mapper.class, sqlSessionFactory);
        for (${table.className}DO ${table.variableName}DO : ${table.variableName}DOs) {
            ${table.variableName}DO.setCreateBy(userId);
            ${table.variableName}DO.setUpdateBy(userId);
            insertBatchAction.addAction(mapper -> mapper.insertSelective(${table.variableName}DO));
        }
        insertBatchAction.doBatchActions();
    }

    /**
     * 批量更新${table.comment!table.className}
     *
     * @param userId       {@code Long} 用户id
     * @param ${table.variableName}DOs {@link ${table.className}DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateBatch${table.className}DOsByPrimaryKey(Long userId, final List<${table.className}DO> ${table.variableName}DOs) {
        if (CollectionUtils.isEmpty(${table.variableName}DOs)) {
            return;
        }
        final MapperBatchAction<${table.className}Mapper> updateBatchAction = MapperBatchAction
                .create(${table.className}Mapper.class, sqlSessionFactory);
        for (${table.className}DO ${table.variableName}DO : ${table.variableName}DOs) {
            ${table.variableName}DO.setUpdateBy(userId);
            UpdateQuery<${table.className}DO> updateQuery = UpdateQuery.createQuery(${table.className}DO.class)
                    .set(${table.variableName}DO, ignore -> ignore.ignore(${table.className}DO::getId,
                            ${table.className}DO::getCreateTime,
                            ${table.className}DO::getCreateBy,
                            ${table.className}DO::getUpdateTime))
                    .and(${table.className}DO::getId, isEqual(${table.variableName}DO.getId()));
            updateBatchAction.addAction(mapper -> mapper.updateByUpdateQuery(updateQuery));
        }
        updateBatchAction.doBatchActions();
    }

    /**
     * 更新${table.comment!table.className}删除状态
     *
     * @param userId  用户id
     * @param ids     id列表
     * @param deleted 删除状态
     */
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        UpdateQuery<${table.className}DO> updateQuery = UpdateQuery.createQuery(${table.className}DO.class)
                .set(${table.className}DO::getDeleted, deleted)
                .set(${table.className}DO::getUpdateBy, userId)
                .and(${table.className}DO::getId, c -> c.in(ids));
        ${table.variableName}Mapper.updateByUpdateQuery(updateQuery);
    }

    /**
     * 根据id查询${table.comment!table.className}
     *
     * @param id 主键id
     * @return {@link ${table.className}DO}
     */
    public Optional<${table.className}DO> get${table.className}DOById(Long id) {
        return Optional.ofNullable(${table.variableName}Mapper.selectByPrimaryKey(id));
    }

    /**
     * 分页查询${table.comment!table.className}
     *
     * @param ${table.variableName}QueryBO {@link ${table.className}QueryBO}
     * @param pageSize    每页大小
     * @param pageNum     页码
     * @return {@link NormPagingResult}
     */
    public NormPagingResult<${table.className}DO> pageQuery(
            ${table.className}QueryBO ${table.variableName}QueryBO, Integer pageSize, Integer pageNum,
            String sortProperty, SortDirection sortDirection) {
        NormPagingQuery<${table.className}DO> query =
                NormPagingQuery.createQuery(${table.className}DO.class, pageNum, pageSize, false, true)
                        .and(Objects.nonNull(${table.variableName}QueryBO.getDeleted()),
                                ${table.className}DO::getDeleted, isEqual(${table.variableName}QueryBO.getDeleted()));
        query.addSorts(new SortDescriptor(sortProperty, sortDirection));
        return ${table.variableName}Mapper.selectByNormalPaging(query);
    }

    /**
     * 获取DB中已经存在的${table.comment!table.className}数据
     *
     * @return map key:业务key value:id
     */
    public Map<String, Long> getBusinessKeyToIdMap(Collection<${table.className}DO> ${table.variableName}DOs) {
        DynamicQuery<${table.className}DO> dynamicQuery = DynamicQuery.createQuery(${table.className}DO.class)
                .select(${table.className}DO::getId);
        for (${table.className}DO ${table.variableName}DO : ${table.variableName}DOs) {
            dynamicQuery.or(${table.className}DO::getId, isEqual(${table.variableName}DO.getId()));
        }
        return ${table.variableName}Mapper.selectByDynamicQuery(dynamicQuery).stream()
                .collect(Collectors.toMap(this::getBusinessKey, ${table.className}DO::getId, (v1, v2) -> v2));
    }

    /**
     * 获取${table.comment!table.className}业务key
     *
     * @param ${table.variableName}DO {@link ${table.className}DO}
     * @return 业务key
     */
    public String getBusinessKey(${table.className}DO ${table.variableName}DO) {
        return String.valueOf(${table.variableName}DO.getId());
    }
}
