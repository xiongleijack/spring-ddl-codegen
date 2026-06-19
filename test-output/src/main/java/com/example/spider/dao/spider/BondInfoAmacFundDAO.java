package com.example.spider.dao.spider;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.UpdateQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.batch.MapperBatchAction;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import com.example.spider.mapper.spider.BondInfoAmacFundMapper;
import com.example.spider.model.entity.spider.BondInfoAmacFundDO;
import com.example.spider.model.bo.BondInfoAmacFundQueryBO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 中国证券投资基金业协会基金表数据库访问层 {@link BondInfoAmacFundDO}
 * 对BondInfoAmacFundMapper层做出简单封装 {@link BondInfoAmacFundMapper}
 *
 * @author xionglei
 */
@Repository
public class BondInfoAmacFundDAO {

    @Resource
    private BondInfoAmacFundMapper bondInfoAmacFundMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 幂等保存中国证券投资基金业协会基金 bondInfoAmacFundDOs
     *
     * @param userId       {@code Long} 用户id
     * @param bondInfoAmacFundDOs {@link BondInfoAmacFundDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveBatchBondInfoAmacFundDOs(Long userId, final Collection<BondInfoAmacFundDO> bondInfoAmacFundDOs) {
        if (CollectionUtils.isEmpty(bondInfoAmacFundDOs)) {
            return;
        }
        Map<String, Long> businessKeyToIdMap = getBusinessKeyToIdMap(bondInfoAmacFundDOs);
        List<BondInfoAmacFundDO> insertList = Lists.newArrayListWithExpectedSize(bondInfoAmacFundDOs.size());
        List<BondInfoAmacFundDO> updateList = Lists.newArrayListWithExpectedSize(bondInfoAmacFundDOs.size());
        for (BondInfoAmacFundDO bondInfoAmacFundDO : bondInfoAmacFundDOs) {
            Long oldId = businessKeyToIdMap.get(getBusinessKey(bondInfoAmacFundDO));
            if (Objects.isNull(oldId)) {
                insertList.add(bondInfoAmacFundDO);
            } else {
                bondInfoAmacFundDO.setId(oldId);
                updateList.add(bondInfoAmacFundDO);
            }
        }
        insertBatchBondInfoAmacFundDOs(userId, insertList);
        updateBatchBondInfoAmacFundDOsByPrimaryKey(userId, updateList);
    }

    /**
     * 批量新增中国证券投资基金业协会基金
     *
     * @param userId       {@code Long} 用户id
     * @param bondInfoAmacFundDOs {@link BondInfoAmacFundDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBatchBondInfoAmacFundDOs(Long userId, final List<BondInfoAmacFundDO> bondInfoAmacFundDOs) {
        if (CollectionUtils.isEmpty(bondInfoAmacFundDOs)) {
            return;
        }
        final MapperBatchAction<BondInfoAmacFundMapper> insertBatchAction = MapperBatchAction
                .create(BondInfoAmacFundMapper.class, sqlSessionFactory);
        for (BondInfoAmacFundDO bondInfoAmacFundDO : bondInfoAmacFundDOs) {
            bondInfoAmacFundDO.setCreateBy(userId);
            bondInfoAmacFundDO.setUpdateBy(userId);
            insertBatchAction.addAction(mapper -> mapper.insertSelective(bondInfoAmacFundDO));
        }
        insertBatchAction.doBatchActions();
    }

    /**
     * 批量更新中国证券投资基金业协会基金
     *
     * @param userId       {@code Long} 用户id
     * @param bondInfoAmacFundDOs {@link BondInfoAmacFundDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateBatchBondInfoAmacFundDOsByPrimaryKey(Long userId, final List<BondInfoAmacFundDO> bondInfoAmacFundDOs) {
        if (CollectionUtils.isEmpty(bondInfoAmacFundDOs)) {
            return;
        }
        final MapperBatchAction<BondInfoAmacFundMapper> updateBatchAction = MapperBatchAction
                .create(BondInfoAmacFundMapper.class, sqlSessionFactory);
        for (BondInfoAmacFundDO bondInfoAmacFundDO : bondInfoAmacFundDOs) {
            bondInfoAmacFundDO.setUpdateBy(userId);
            UpdateQuery<BondInfoAmacFundDO> updateQuery = UpdateQuery.createQuery(BondInfoAmacFundDO.class)
                    .set(bondInfoAmacFundDO, ignore -> ignore.ignore(BondInfoAmacFundDO::getId,
                            BondInfoAmacFundDO::getCreateTime,
                            BondInfoAmacFundDO::getCreateBy,
                            BondInfoAmacFundDO::getUpdateTime))
                    .and(BondInfoAmacFundDO::getId, isEqual(bondInfoAmacFundDO.getId()));
            updateBatchAction.addAction(mapper -> mapper.updateByUpdateQuery(updateQuery));
        }
        updateBatchAction.doBatchActions();
    }

    /**
     * 更新中国证券投资基金业协会基金删除状态
     *
     * @param userId  用户id
     * @param ids     id列表
     * @param deleted 删除状态
     */
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        UpdateQuery<BondInfoAmacFundDO> updateQuery = UpdateQuery.createQuery(BondInfoAmacFundDO.class)
                .set(BondInfoAmacFundDO::getDeleted, deleted)
                .set(BondInfoAmacFundDO::getUpdateBy, userId)
                .and(BondInfoAmacFundDO::getId, c -> c.in(ids));
        bondInfoAmacFundMapper.updateByUpdateQuery(updateQuery);
    }

    /**
     * 根据id查询中国证券投资基金业协会基金
     *
     * @param id 主键id
     * @return {@link BondInfoAmacFundDO}
     */
    public Optional<BondInfoAmacFundDO> getBondInfoAmacFundDOById(Long id) {
        return Optional.ofNullable(bondInfoAmacFundMapper.selectByPrimaryKey(id));
    }

    /**
     * 分页查询中国证券投资基金业协会基金
     *
     * @param bondInfoAmacFundQueryBO {@link BondInfoAmacFundQueryBO}
     * @param pageSize    每页大小
     * @param pageNum     页码
     * @return {@link NormPagingResult}
     */
    public NormPagingResult<BondInfoAmacFundDO> pageQuery(
            BondInfoAmacFundQueryBO bondInfoAmacFundQueryBO, Integer pageSize, Integer pageNum,
            String sortProperty, SortDirection sortDirection) {
        NormPagingQuery<BondInfoAmacFundDO> query =
                NormPagingQuery.createQuery(BondInfoAmacFundDO.class, pageNum, pageSize, false, true)
                        .and(Objects.nonNull(bondInfoAmacFundQueryBO.getDeleted()),
                                BondInfoAmacFundDO::getDeleted, isEqual(bondInfoAmacFundQueryBO.getDeleted()));
        query.addSorts(new SortDescriptor(sortProperty, sortDirection));
        return bondInfoAmacFundMapper.selectByNormalPaging(query);
    }

    /**
     * 获取DB中已经存在的中国证券投资基金业协会基金数据
     *
     * @return map key:业务key value:id
     */
    public Map<String, Long> getBusinessKeyToIdMap(Collection<BondInfoAmacFundDO> bondInfoAmacFundDOs) {
        DynamicQuery<BondInfoAmacFundDO> dynamicQuery = DynamicQuery.createQuery(BondInfoAmacFundDO.class)
                .select(BondInfoAmacFundDO::getId);
        for (BondInfoAmacFundDO bondInfoAmacFundDO : bondInfoAmacFundDOs) {
            dynamicQuery.or(BondInfoAmacFundDO::getId, isEqual(bondInfoAmacFundDO.getId()));
        }
        return bondInfoAmacFundMapper.selectByDynamicQuery(dynamicQuery).stream()
                .collect(Collectors.toMap(this::getBusinessKey, BondInfoAmacFundDO::getId, (v1, v2) -> v2));
    }

    /**
     * 获取中国证券投资基金业协会基金业务key
     *
     * @param bondInfoAmacFundDO {@link BondInfoAmacFundDO}
     * @return 业务key
     */
    public String getBusinessKey(BondInfoAmacFundDO bondInfoAmacFundDO) {
        return String.valueOf(bondInfoAmacFundDO.getId());
    }
}
