package com.example.onshore.dao.bondbasic;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.UpdateQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.batch.MapperBatchAction;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import com.example.onshore.mapper.bondbasic.OnshoreBondFilterV3Mapper;
import com.example.onshore.model.entity.bondbasic.OnshoreBondFilterV3DO;
import com.example.onshore.model.bo.OnshoreBondFilterV3QueryBO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 表数据库访问层 {@link OnshoreBondFilterV3DO}
 * 对OnshoreBondFilterV3Mapper层做出简单封装 {@link OnshoreBondFilterV3Mapper}
 *
 * @author xionglei
 */
@Repository
public class OnshoreBondFilterV3DAO {

    @Resource
    private OnshoreBondFilterV3Mapper onshoreBondFilterV3Mapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 幂等保存 onshoreBondFilterV3DOs
     *
     * @param userId       {@code Long} 用户id
     * @param onshoreBondFilterV3DOs {@link OnshoreBondFilterV3DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveBatchOnshoreBondFilterV3DOs(Long userId, final Collection<OnshoreBondFilterV3DO> onshoreBondFilterV3DOs) {
        if (CollectionUtils.isEmpty(onshoreBondFilterV3DOs)) {
            return;
        }
        Map<String, Long> businessKeyToIdMap = getBusinessKeyToIdMap(onshoreBondFilterV3DOs);
        List<OnshoreBondFilterV3DO> insertList = Lists.newArrayListWithExpectedSize(onshoreBondFilterV3DOs.size());
        List<OnshoreBondFilterV3DO> updateList = Lists.newArrayListWithExpectedSize(onshoreBondFilterV3DOs.size());
        for (OnshoreBondFilterV3DO onshoreBondFilterV3DO : onshoreBondFilterV3DOs) {
            Long oldId = businessKeyToIdMap.get(getBusinessKey(onshoreBondFilterV3DO));
            if (Objects.isNull(oldId)) {
                insertList.add(onshoreBondFilterV3DO);
            } else {
                onshoreBondFilterV3DO.setId(oldId);
                updateList.add(onshoreBondFilterV3DO);
            }
        }
        insertBatchOnshoreBondFilterV3DOs(userId, insertList);
        updateBatchOnshoreBondFilterV3DOsByPrimaryKey(userId, updateList);
    }

    /**
     * 批量新增
     *
     * @param userId       {@code Long} 用户id
     * @param onshoreBondFilterV3DOs {@link OnshoreBondFilterV3DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBatchOnshoreBondFilterV3DOs(Long userId, final List<OnshoreBondFilterV3DO> onshoreBondFilterV3DOs) {
        if (CollectionUtils.isEmpty(onshoreBondFilterV3DOs)) {
            return;
        }
        final MapperBatchAction<OnshoreBondFilterV3Mapper> insertBatchAction = MapperBatchAction
                .create(OnshoreBondFilterV3Mapper.class, sqlSessionFactory);
        for (OnshoreBondFilterV3DO onshoreBondFilterV3DO : onshoreBondFilterV3DOs) {
            onshoreBondFilterV3DO.setCreateBy(userId);
            onshoreBondFilterV3DO.setUpdateBy(userId);
            insertBatchAction.addAction(mapper -> mapper.insertSelective(onshoreBondFilterV3DO));
        }
        insertBatchAction.doBatchActions();
    }

    /**
     * 批量更新
     *
     * @param userId       {@code Long} 用户id
     * @param onshoreBondFilterV3DOs {@link OnshoreBondFilterV3DO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateBatchOnshoreBondFilterV3DOsByPrimaryKey(Long userId, final List<OnshoreBondFilterV3DO> onshoreBondFilterV3DOs) {
        if (CollectionUtils.isEmpty(onshoreBondFilterV3DOs)) {
            return;
        }
        final MapperBatchAction<OnshoreBondFilterV3Mapper> updateBatchAction = MapperBatchAction
                .create(OnshoreBondFilterV3Mapper.class, sqlSessionFactory);
        for (OnshoreBondFilterV3DO onshoreBondFilterV3DO : onshoreBondFilterV3DOs) {
            onshoreBondFilterV3DO.setUpdateBy(userId);
            UpdateQuery<OnshoreBondFilterV3DO> updateQuery = UpdateQuery.createQuery(OnshoreBondFilterV3DO.class)
                    .set(onshoreBondFilterV3DO, ignore -> ignore.ignore(OnshoreBondFilterV3DO::getId,
                            OnshoreBondFilterV3DO::getCreateTime,
                            OnshoreBondFilterV3DO::getCreateBy,
                            OnshoreBondFilterV3DO::getUpdateTime))
                    .and(OnshoreBondFilterV3DO::getId, isEqual(onshoreBondFilterV3DO.getId()));
            updateBatchAction.addAction(mapper -> mapper.updateByUpdateQuery(updateQuery));
        }
        updateBatchAction.doBatchActions();
    }

    /**
     * 更新删除状态
     *
     * @param userId  用户id
     * @param ids     id列表
     * @param deleted 删除状态
     */
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        UpdateQuery<OnshoreBondFilterV3DO> updateQuery = UpdateQuery.createQuery(OnshoreBondFilterV3DO.class)
                .set(OnshoreBondFilterV3DO::getDeleted, deleted)
                .set(OnshoreBondFilterV3DO::getUpdateBy, userId)
                .and(OnshoreBondFilterV3DO::getId, c -> c.in(ids));
        onshoreBondFilterV3Mapper.updateByUpdateQuery(updateQuery);
    }

    /**
     * 根据id查询
     *
     * @param id 主键id
     * @return {@link OnshoreBondFilterV3DO}
     */
    public Optional<OnshoreBondFilterV3DO> getOnshoreBondFilterV3DOById(Long id) {
        return Optional.ofNullable(onshoreBondFilterV3Mapper.selectByPrimaryKey(id));
    }

    /**
     * 分页查询
     *
     * @param onshoreBondFilterV3QueryBO {@link OnshoreBondFilterV3QueryBO}
     * @param pageSize    每页大小
     * @param pageNum     页码
     * @return {@link NormPagingResult}
     */
    public NormPagingResult<OnshoreBondFilterV3DO> pageQuery(
            OnshoreBondFilterV3QueryBO onshoreBondFilterV3QueryBO, Integer pageSize, Integer pageNum,
            String sortProperty, SortDirection sortDirection) {
        NormPagingQuery<OnshoreBondFilterV3DO> query =
                NormPagingQuery.createQuery(OnshoreBondFilterV3DO.class, pageNum, pageSize, false, true)
                        .and(Objects.nonNull(onshoreBondFilterV3QueryBO.getDeleted()),
                                OnshoreBondFilterV3DO::getDeleted, isEqual(onshoreBondFilterV3QueryBO.getDeleted()));
        query.addSorts(new SortDescriptor(sortProperty, sortDirection));
        return onshoreBondFilterV3Mapper.selectByNormalPaging(query);
    }

    /**
     * 获取DB中已经存在的数据
     *
     * @return map key:业务key value:id
     */
    public Map<String, Long> getBusinessKeyToIdMap(Collection<OnshoreBondFilterV3DO> onshoreBondFilterV3DOs) {
        DynamicQuery<OnshoreBondFilterV3DO> dynamicQuery = DynamicQuery.createQuery(OnshoreBondFilterV3DO.class)
                .select(OnshoreBondFilterV3DO::getId);
        for (OnshoreBondFilterV3DO onshoreBondFilterV3DO : onshoreBondFilterV3DOs) {
            dynamicQuery.or(OnshoreBondFilterV3DO::getId, isEqual(onshoreBondFilterV3DO.getId()));
        }
        return onshoreBondFilterV3Mapper.selectByDynamicQuery(dynamicQuery).stream()
                .collect(Collectors.toMap(this::getBusinessKey, OnshoreBondFilterV3DO::getId, (v1, v2) -> v2));
    }

    /**
     * 获取业务key
     *
     * @param onshoreBondFilterV3DO {@link OnshoreBondFilterV3DO}
     * @return 业务key
     */
    public String getBusinessKey(OnshoreBondFilterV3DO onshoreBondFilterV3DO) {
        return String.valueOf(onshoreBondFilterV3DO.getId());
    }
}
