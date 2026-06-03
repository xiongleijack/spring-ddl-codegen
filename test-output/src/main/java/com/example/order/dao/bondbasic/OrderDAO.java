package com.example.order.dao.bondbasic;

import com.github.wz2cool.dynamic.*;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.UpdateQuery;
import com.github.wz2cool.dynamic.mybatis.mapper.batch.MapperBatchAction;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;
import com.example.order.mapper.bondbasic.OrderMapper;
import com.example.order.model.entity.bondbasic.OrderDO;
import com.example.order.model.bo.OrderQueryBO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.isEqual;
import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 订单表表数据库访问层 {@link OrderDO}
 * 对OrderMapper层做出简单封装 {@link OrderMapper}
 *
 * @author xionglei
 */
@Repository
public class OrderDAO {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 幂等保存订单表 orderDOs
     *
     * @param userId       {@code Long} 用户id
     * @param orderDOs {@link OrderDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveBatchOrderDOs(Long userId, final Collection<OrderDO> orderDOs) {
        if (CollectionUtils.isEmpty(orderDOs)) {
            return;
        }
        Map<String, Long> businessKeyToIdMap = getBusinessKeyToIdMap(orderDOs);
        List<OrderDO> insertList = Lists.newArrayListWithExpectedSize(orderDOs.size());
        List<OrderDO> updateList = Lists.newArrayListWithExpectedSize(orderDOs.size());
        for (OrderDO orderDO : orderDOs) {
            Long oldId = businessKeyToIdMap.get(getBusinessKey(orderDO));
            if (Objects.isNull(oldId)) {
                insertList.add(orderDO);
            } else {
                orderDO.setId(oldId);
                updateList.add(orderDO);
            }
        }
        insertBatchOrderDOs(userId, insertList);
        updateBatchOrderDOsByPrimaryKey(userId, updateList);
    }

    /**
     * 批量新增订单表
     *
     * @param userId       {@code Long} 用户id
     * @param orderDOs {@link OrderDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertBatchOrderDOs(Long userId, final List<OrderDO> orderDOs) {
        if (CollectionUtils.isEmpty(orderDOs)) {
            return;
        }
        final MapperBatchAction<OrderMapper> insertBatchAction = MapperBatchAction
                .create(OrderMapper.class, sqlSessionFactory);
        for (OrderDO orderDO : orderDOs) {
            orderDO.setCreateBy(userId);
            orderDO.setUpdateBy(userId);
            insertBatchAction.addAction(mapper -> mapper.insertSelective(orderDO));
        }
        insertBatchAction.doBatchActions();
    }

    /**
     * 批量更新订单表
     *
     * @param userId       {@code Long} 用户id
     * @param orderDOs {@link OrderDO}
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateBatchOrderDOsByPrimaryKey(Long userId, final List<OrderDO> orderDOs) {
        if (CollectionUtils.isEmpty(orderDOs)) {
            return;
        }
        final MapperBatchAction<OrderMapper> updateBatchAction = MapperBatchAction
                .create(OrderMapper.class, sqlSessionFactory);
        for (OrderDO orderDO : orderDOs) {
            orderDO.setUpdateBy(userId);
            UpdateQuery<OrderDO> updateQuery = UpdateQuery.createQuery(OrderDO.class)
                    .set(orderDO, ignore -> ignore.ignore(OrderDO::getId,
                            OrderDO::getCreateTime,
                            OrderDO::getCreateBy,
                            OrderDO::getUpdateTime))
                    .and(OrderDO::getId, isEqual(orderDO.getId()));
            updateBatchAction.addAction(mapper -> mapper.updateByUpdateQuery(updateQuery));
        }
        updateBatchAction.doBatchActions();
    }

    /**
     * 更新订单表删除状态
     *
     * @param userId  用户id
     * @param ids     id列表
     * @param deleted 删除状态
     */
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        UpdateQuery<OrderDO> updateQuery = UpdateQuery.createQuery(OrderDO.class)
                .set(OrderDO::getDeleted, deleted)
                .set(OrderDO::getUpdateBy, userId)
                .and(OrderDO::getId, c -> c.in(ids));
        orderMapper.updateByUpdateQuery(updateQuery);
    }

    /**
     * 根据id查询订单表
     *
     * @param id 主键id
     * @return {@link OrderDO}
     */
    public Optional<OrderDO> getOrderDOById(Long id) {
        return Optional.ofNullable(orderMapper.selectByPrimaryKey(id));
    }

    /**
     * 分页查询订单表
     *
     * @param orderQueryBO {@link OrderQueryBO}
     * @param pageSize    每页大小
     * @param pageNum     页码
     * @return {@link NormPagingResult}
     */
    public NormPagingResult<OrderDO> pageQuery(
            OrderQueryBO orderQueryBO, Integer pageSize, Integer pageNum,
            String sortProperty, SortDirection sortDirection) {
        NormPagingQuery<OrderDO> query =
                NormPagingQuery.createQuery(OrderDO.class, pageNum, pageSize, false, true)
                        .and(Objects.nonNull(orderQueryBO.getDeleted()),
                                OrderDO::getDeleted, isEqual(orderQueryBO.getDeleted()));
        query.addSorts(new SortDescriptor(sortProperty, sortDirection));
        return orderMapper.selectByNormalPaging(query);
    }

    /**
     * 获取DB中已经存在的订单表数据
     *
     * @return map key:业务key value:id
     */
    public Map<String, Long> getBusinessKeyToIdMap(Collection<OrderDO> orderDOs) {
        DynamicQuery<OrderDO> dynamicQuery = DynamicQuery.createQuery(OrderDO.class)
                .select(OrderDO::getId);
        for (OrderDO orderDO : orderDOs) {
            dynamicQuery.or(OrderDO::getId, isEqual(orderDO.getId()));
        }
        return orderMapper.selectByDynamicQuery(dynamicQuery).stream()
                .collect(Collectors.toMap(this::getBusinessKey, OrderDO::getId, (v1, v2) -> v2));
    }

    /**
     * 获取订单表业务key
     *
     * @param orderDO {@link OrderDO}
     * @return 业务key
     */
    public String getBusinessKey(OrderDO orderDO) {
        return String.valueOf(orderDO.getId());
    }
}
