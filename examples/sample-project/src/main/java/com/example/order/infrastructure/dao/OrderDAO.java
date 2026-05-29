package com.example.order.infrastructure.dao;

import com.example.order.domain.entity.OrderDO;
import com.example.order.domain.bo.OrderQueryBO;
import com.example.order.infrastructure.mapper.OrderMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * 订单表表数据库访问层
 *
 * @author codegen
 */
@Repository
public class OrderDAO {

    @Resource
    private OrderMapper orderMapper;

    public Optional<OrderDO> getById(Long id) {
        return Optional.ofNullable(orderMapper.selectById(id));
    }

    public OrderDO getByOrderno(String orderNo) {
        return orderMapper.selectByOrderno(orderNo);
    }

    public Page<OrderDO> pageQuery(Page<OrderDO> page, OrderQueryBO queryBO) {
        LambdaQueryWrapper<OrderDO> wrapper = buildWrapper(queryBO);
        return orderMapper.selectPage(page, wrapper);
    }

    public List<OrderDO> listByCondition(OrderQueryBO queryBO) {
        return orderMapper.selectList(buildWrapper(queryBO));
    }

    public int insert(OrderDO entity) {
        return orderMapper.insert(entity);
    }

    public int updateById(OrderDO entity) {
        return orderMapper.updateById(entity);
    }

    public int deleteById(Long id) {
        return orderMapper.deleteById(id);
    }

    public int insertBatch(List<OrderDO> entities) {
        int count = 0;
        for (OrderDO entity : entities) {
            count += orderMapper.insert(entity);
        }
        return count;
    }

    private LambdaQueryWrapper<OrderDO> buildWrapper(OrderQueryBO queryBO) {
        LambdaQueryWrapper<OrderDO> wrapper = new LambdaQueryWrapper<>();
        if (queryBO == null) {
            return wrapper;
        }
        if (StringUtils.hasText(queryBO.getOrderno())) {
            wrapper.eq(OrderDO::getOrderno, queryBO.getOrderno());
        }
        if (queryBO.getUserid() != null) {
            wrapper.eq(OrderDO::getUserid, queryBO.getUserid());
        }
        if (queryBO.getStatus() != null) {
            wrapper.eq(OrderDO::getStatus, queryBO.getStatus());
        }
        return wrapper;
    }
}
