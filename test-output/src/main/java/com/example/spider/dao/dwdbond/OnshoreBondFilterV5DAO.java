package com.example.spider.dao.dwdbond;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.UpdateQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.batch.MapperBatchAction;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import com.example.spider.mapper.dwdbond.OnshoreBondFilterV5Mapper;
import com.example.spider.model.entity.dwdbond.OnshoreBondFilterV5DO;
import com.example.spider.model.bo.OnshoreBondFilterV5QueryBO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标表数据库访问层 {@link OnshoreBondFilterV5DO}
 * 对OnshoreBondFilterV5Mapper层做出简单封装 {@link OnshoreBondFilterV5Mapper}
 *
 * @author xionglei
 */
@Repository
public class OnshoreBondFilterV5DAO {

    @Resource
    private OnshoreBondFilterV5Mapper onshoreBondFilterV5Mapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 幂等保存境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标 onshoreBondFilterV5DOs
     *
     * @param userId       {@code Long} 用户id
     * @param onshoreBondFilterV5DOs {@link OnshoreBondFilterV5DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveBatchOnshoreBondFilterV5DOs(Long userId, final Collection<OnshoreBondFilterV5DO> onshoreBondFilterV5DOs) {
        if (CollectionUtils.isEmpty(onshoreBondFilterV5DOs)) {
            return;
        }
        Map<String, Long> businessKeyToIdMap = getBusinessKeyToIdMap(onshoreBondFilterV5DOs);
        List<OnshoreBondFilterV5DO> insertList = Lists.newArrayListWithExpectedSize(onshoreBondFilterV5DOs.size());
        List<OnshoreBondFilterV5DO> updateList = Lists.newArrayListWithExpectedSize(onshoreBondFilterV5DOs.size());
        for (OnshoreBondFilterV5DO onshoreBondFilterV5DO : onshoreBondFilterV5DOs) {
            Long oldId = businessKeyToIdMap.get(getBusinessKey(onshoreBondFilterV5DO));
            if (Objects.isNull(oldId)) {
                insertList.add(onshoreBondFilterV5DO);
            } else {
                onshoreBondFilterV5DO.setId(oldId);
                updateList.add(onshoreBondFilterV5DO);
            }
        }
        insertBatchOnshoreBondFilterV5DOs(userId, insertList);
        updateBatchOnshoreBondFilterV5DOsByPrimaryKey(userId, updateList);
    }

    /**
     * 批量新增境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标
     *
     * @param userId       {@code Long} 用户id
     * @param onshoreBondFilterV5DOs {@link OnshoreBondFilterV5DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBatchOnshoreBondFilterV5DOs(Long userId, final List<OnshoreBondFilterV5DO> onshoreBondFilterV5DOs) {
        if (CollectionUtils.isEmpty(onshoreBondFilterV5DOs)) {
            return;
        }
        final MapperBatchAction<OnshoreBondFilterV5Mapper> insertBatchAction = MapperBatchAction
                .create(OnshoreBondFilterV5Mapper.class, sqlSessionFactory);
        for (OnshoreBondFilterV5DO onshoreBondFilterV5DO : onshoreBondFilterV5DOs) {
            onshoreBondFilterV5DO.setCreateBy(userId);
            onshoreBondFilterV5DO.setUpdateBy(userId);
            insertBatchAction.addAction(mapper -> mapper.insertSelective(onshoreBondFilterV5DO));
        }
        insertBatchAction.doBatchActions();
    }

    /**
     * 批量更新境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标
     *
     * @param userId       {@code Long} 用户id
     * @param onshoreBondFilterV5DOs {@link OnshoreBondFilterV5DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateBatchOnshoreBondFilterV5DOsByPrimaryKey(Long userId, final List<OnshoreBondFilterV5DO> onshoreBondFilterV5DOs) {
        if (CollectionUtils.isEmpty(onshoreBondFilterV5DOs)) {
            return;
        }
        final MapperBatchAction<OnshoreBondFilterV5Mapper> updateBatchAction = MapperBatchAction
                .create(OnshoreBondFilterV5Mapper.class, sqlSessionFactory);
        for (OnshoreBondFilterV5DO onshoreBondFilterV5DO : onshoreBondFilterV5DOs) {
            onshoreBondFilterV5DO.setUpdateBy(userId);
            UpdateQuery<OnshoreBondFilterV5DO> updateQuery = UpdateQuery.createQuery(OnshoreBondFilterV5DO.class)
                    .set(onshoreBondFilterV5DO, ignore -> ignore.ignore(OnshoreBondFilterV5DO::getId,
                            OnshoreBondFilterV5DO::getCreateTime,
                            OnshoreBondFilterV5DO::getCreateBy,
                            OnshoreBondFilterV5DO::getUpdateTime))
                    .and(OnshoreBondFilterV5DO::getId, isEqual(onshoreBondFilterV5DO.getId()));
            updateBatchAction.addAction(mapper -> mapper.updateByUpdateQuery(updateQuery));
        }
        updateBatchAction.doBatchActions();
    }

    /**
     * 更新境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标删除状态
     *
     * @param userId  用户id
     * @param ids     id列表
     * @param deleted 删除状态
     */
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        UpdateQuery<OnshoreBondFilterV5DO> updateQuery = UpdateQuery.createQuery(OnshoreBondFilterV5DO.class)
                .set(OnshoreBondFilterV5DO::getDeleted, deleted)
                .set(OnshoreBondFilterV5DO::getUpdateBy, userId)
                .and(OnshoreBondFilterV5DO::getId, c -> c.in(ids));
        onshoreBondFilterV5Mapper.updateByUpdateQuery(updateQuery);
    }

    /**
     * 根据id查询境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标
     *
     * @param id 主键id
     * @return {@link OnshoreBondFilterV5DO}
     */
    public Optional<OnshoreBondFilterV5DO> getOnshoreBondFilterV5DOById(Long id) {
        return Optional.ofNullable(onshoreBondFilterV5Mapper.selectByPrimaryKey(id));
    }

    /**
     * 分页查询境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标
     *
     * @param onshoreBondFilterV5QueryBO {@link OnshoreBondFilterV5QueryBO}
     * @param pageSize    每页大小
     * @param pageNum     页码
     * @return {@link NormPagingResult}
     */
    public NormPagingResult<OnshoreBondFilterV5DO> pageQuery(
            OnshoreBondFilterV5QueryBO onshoreBondFilterV5QueryBO, Integer pageSize, Integer pageNum,
            String sortProperty, SortDirection sortDirection) {
        NormPagingQuery<OnshoreBondFilterV5DO> query =
                NormPagingQuery.createQuery(OnshoreBondFilterV5DO.class, pageNum, pageSize, false, true)
                        .and(Objects.nonNull(onshoreBondFilterV5QueryBO.getDeleted()),
                                OnshoreBondFilterV5DO::getDeleted, isEqual(onshoreBondFilterV5QueryBO.getDeleted()));
        query.addSorts(new SortDescriptor(sortProperty, sortDirection));
        return onshoreBondFilterV5Mapper.selectByNormalPaging(query);
    }

    /**
     * 获取DB中已经存在的境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标数据
     *
     * @return map key:业务key value:id
     */
    public Map<String, Long> getBusinessKeyToIdMap(Collection<OnshoreBondFilterV5DO> onshoreBondFilterV5DOs) {
        DynamicQuery<OnshoreBondFilterV5DO> dynamicQuery = DynamicQuery.createQuery(OnshoreBondFilterV5DO.class)
                .select(OnshoreBondFilterV5DO::getId);
        for (OnshoreBondFilterV5DO onshoreBondFilterV5DO : onshoreBondFilterV5DOs) {
            dynamicQuery.or(OnshoreBondFilterV5DO::getId, isEqual(onshoreBondFilterV5DO.getId()));
        }
        return onshoreBondFilterV5Mapper.selectByDynamicQuery(dynamicQuery).stream()
                .collect(Collectors.toMap(this::getBusinessKey, OnshoreBondFilterV5DO::getId, (v1, v2) -> v2));
    }

    /**
     * 获取境内债券筛选V3宽表（旧onshore_bond_filter超集+F9/DeepInfo/list复刻字段），每个bondUniCode一行，软删，update_time为增量游标业务key
     *
     * @param onshoreBondFilterV5DO {@link OnshoreBondFilterV5DO}
     * @return 业务key
     */
    public String getBusinessKey(OnshoreBondFilterV5DO onshoreBondFilterV5DO) {
        return String.valueOf(onshoreBondFilterV5DO.getId());
    }
}
