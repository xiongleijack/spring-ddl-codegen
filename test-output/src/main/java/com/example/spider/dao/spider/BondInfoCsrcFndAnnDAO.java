package com.example.spider.dao.spider;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.UpdateQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.batch.MapperBatchAction;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import com.example.spider.mapper.spider.BondInfoCsrcFndAnnMapper;
import com.example.spider.model.entity.spider.BondInfoCsrcFndAnnDO;
import com.example.spider.model.bo.BondInfoCsrcFndAnnQueryBO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 中国证券监督管理委员会基金公告-补充表数据库访问层 {@link BondInfoCsrcFndAnnDO}
 * 对BondInfoCsrcFndAnnMapper层做出简单封装 {@link BondInfoCsrcFndAnnMapper}
 *
 * @author xionglei
 */
@Repository
public class BondInfoCsrcFndAnnDAO {

    @Resource
    private BondInfoCsrcFndAnnMapper bondInfoCsrcFndAnnMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 幂等保存中国证券监督管理委员会基金公告-补充 bondInfoCsrcFndAnnDOs
     *
     * @param userId       {@code Long} 用户id
     * @param bondInfoCsrcFndAnnDOs {@link BondInfoCsrcFndAnnDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveBatchBondInfoCsrcFndAnnDOs(Long userId, final Collection<BondInfoCsrcFndAnnDO> bondInfoCsrcFndAnnDOs) {
        if (CollectionUtils.isEmpty(bondInfoCsrcFndAnnDOs)) {
            return;
        }
        Map<String, Long> businessKeyToIdMap = getBusinessKeyToIdMap(bondInfoCsrcFndAnnDOs);
        List<BondInfoCsrcFndAnnDO> insertList = Lists.newArrayListWithExpectedSize(bondInfoCsrcFndAnnDOs.size());
        List<BondInfoCsrcFndAnnDO> updateList = Lists.newArrayListWithExpectedSize(bondInfoCsrcFndAnnDOs.size());
        for (BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO : bondInfoCsrcFndAnnDOs) {
            Long oldId = businessKeyToIdMap.get(getBusinessKey(bondInfoCsrcFndAnnDO));
            if (Objects.isNull(oldId)) {
                insertList.add(bondInfoCsrcFndAnnDO);
            } else {
                bondInfoCsrcFndAnnDO.setId(oldId);
                updateList.add(bondInfoCsrcFndAnnDO);
            }
        }
        insertBatchBondInfoCsrcFndAnnDOs(userId, insertList);
        updateBatchBondInfoCsrcFndAnnDOsByPrimaryKey(userId, updateList);
    }

    /**
     * 批量新增中国证券监督管理委员会基金公告-补充
     *
     * @param userId       {@code Long} 用户id
     * @param bondInfoCsrcFndAnnDOs {@link BondInfoCsrcFndAnnDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBatchBondInfoCsrcFndAnnDOs(Long userId, final List<BondInfoCsrcFndAnnDO> bondInfoCsrcFndAnnDOs) {
        if (CollectionUtils.isEmpty(bondInfoCsrcFndAnnDOs)) {
            return;
        }
        final MapperBatchAction<BondInfoCsrcFndAnnMapper> insertBatchAction = MapperBatchAction
                .create(BondInfoCsrcFndAnnMapper.class, sqlSessionFactory);
        for (BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO : bondInfoCsrcFndAnnDOs) {
            bondInfoCsrcFndAnnDO.setCreateBy(userId);
            bondInfoCsrcFndAnnDO.setUpdateBy(userId);
            insertBatchAction.addAction(mapper -> mapper.insertSelective(bondInfoCsrcFndAnnDO));
        }
        insertBatchAction.doBatchActions();
    }

    /**
     * 批量更新中国证券监督管理委员会基金公告-补充
     *
     * @param userId       {@code Long} 用户id
     * @param bondInfoCsrcFndAnnDOs {@link BondInfoCsrcFndAnnDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateBatchBondInfoCsrcFndAnnDOsByPrimaryKey(Long userId, final List<BondInfoCsrcFndAnnDO> bondInfoCsrcFndAnnDOs) {
        if (CollectionUtils.isEmpty(bondInfoCsrcFndAnnDOs)) {
            return;
        }
        final MapperBatchAction<BondInfoCsrcFndAnnMapper> updateBatchAction = MapperBatchAction
                .create(BondInfoCsrcFndAnnMapper.class, sqlSessionFactory);
        for (BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO : bondInfoCsrcFndAnnDOs) {
            bondInfoCsrcFndAnnDO.setUpdateBy(userId);
            UpdateQuery<BondInfoCsrcFndAnnDO> updateQuery = UpdateQuery.createQuery(BondInfoCsrcFndAnnDO.class)
                    .set(bondInfoCsrcFndAnnDO, ignore -> ignore.ignore(BondInfoCsrcFndAnnDO::getId,
                            BondInfoCsrcFndAnnDO::getCreateTime,
                            BondInfoCsrcFndAnnDO::getCreateBy,
                            BondInfoCsrcFndAnnDO::getUpdateTime))
                    .and(BondInfoCsrcFndAnnDO::getId, isEqual(bondInfoCsrcFndAnnDO.getId()));
            updateBatchAction.addAction(mapper -> mapper.updateByUpdateQuery(updateQuery));
        }
        updateBatchAction.doBatchActions();
    }

    /**
     * 更新中国证券监督管理委员会基金公告-补充删除状态
     *
     * @param userId  用户id
     * @param ids     id列表
     * @param deleted 删除状态
     */
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        UpdateQuery<BondInfoCsrcFndAnnDO> updateQuery = UpdateQuery.createQuery(BondInfoCsrcFndAnnDO.class)
                .set(BondInfoCsrcFndAnnDO::getDeleted, deleted)
                .set(BondInfoCsrcFndAnnDO::getUpdateBy, userId)
                .and(BondInfoCsrcFndAnnDO::getId, c -> c.in(ids));
        bondInfoCsrcFndAnnMapper.updateByUpdateQuery(updateQuery);
    }

    /**
     * 根据id查询中国证券监督管理委员会基金公告-补充
     *
     * @param id 主键id
     * @return {@link BondInfoCsrcFndAnnDO}
     */
    public Optional<BondInfoCsrcFndAnnDO> getBondInfoCsrcFndAnnDOById(Long id) {
        return Optional.ofNullable(bondInfoCsrcFndAnnMapper.selectByPrimaryKey(id));
    }

    /**
     * 分页查询中国证券监督管理委员会基金公告-补充
     *
     * @param bondInfoCsrcFndAnnQueryBO {@link BondInfoCsrcFndAnnQueryBO}
     * @param pageSize    每页大小
     * @param pageNum     页码
     * @return {@link NormPagingResult}
     */
    public NormPagingResult<BondInfoCsrcFndAnnDO> pageQuery(
            BondInfoCsrcFndAnnQueryBO bondInfoCsrcFndAnnQueryBO, Integer pageSize, Integer pageNum,
            String sortProperty, SortDirection sortDirection) {
        NormPagingQuery<BondInfoCsrcFndAnnDO> query =
                NormPagingQuery.createQuery(BondInfoCsrcFndAnnDO.class, pageNum, pageSize, false, true)
                        .and(Objects.nonNull(bondInfoCsrcFndAnnQueryBO.getDeleted()),
                                BondInfoCsrcFndAnnDO::getDeleted, isEqual(bondInfoCsrcFndAnnQueryBO.getDeleted()));
        query.addSorts(new SortDescriptor(sortProperty, sortDirection));
        return bondInfoCsrcFndAnnMapper.selectByNormalPaging(query);
    }

    /**
     * 获取DB中已经存在的中国证券监督管理委员会基金公告-补充数据
     *
     * @return map key:业务key value:id
     */
    public Map<String, Long> getBusinessKeyToIdMap(Collection<BondInfoCsrcFndAnnDO> bondInfoCsrcFndAnnDOs) {
        DynamicQuery<BondInfoCsrcFndAnnDO> dynamicQuery = DynamicQuery.createQuery(BondInfoCsrcFndAnnDO.class)
                .select(BondInfoCsrcFndAnnDO::getId);
        for (BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO : bondInfoCsrcFndAnnDOs) {
            dynamicQuery.or(BondInfoCsrcFndAnnDO::getId, isEqual(bondInfoCsrcFndAnnDO.getId()));
        }
        return bondInfoCsrcFndAnnMapper.selectByDynamicQuery(dynamicQuery).stream()
                .collect(Collectors.toMap(this::getBusinessKey, BondInfoCsrcFndAnnDO::getId, (v1, v2) -> v2));
    }

    /**
     * 获取中国证券监督管理委员会基金公告-补充业务key
     *
     * @param bondInfoCsrcFndAnnDO {@link BondInfoCsrcFndAnnDO}
     * @return 业务key
     */
    public String getBusinessKey(BondInfoCsrcFndAnnDO bondInfoCsrcFndAnnDO) {
        return String.valueOf(bondInfoCsrcFndAnnDO.getId());
    }
}
