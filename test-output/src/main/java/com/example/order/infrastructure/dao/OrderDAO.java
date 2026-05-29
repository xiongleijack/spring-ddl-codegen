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

    /**
     * 根据主键查询
     */
    public Optional<OrderDO> getById(Long id) {
        return Optional.ofNullable(orderMapper.selectById(id));
    }

    /**
     * 根据业务主键查询
     */
    public OrderDO getByOrderno(String orderNo) {
        return orderMapper.selectByOrderno(orderNo);
    }

    /**
     * 分页查询，根据QueryBO中的非空字段构建查询条件
     */
    public Page<OrderDO> pageQuery(Page<OrderDO> page, OrderQueryBO queryBO) {
        LambdaQueryWrapper<OrderDO> wrapper = buildWrapper(queryBO);
        return orderMapper.selectPage(page, wrapper);
    }

    /**
     * 条件列表查询（不分页）
     */
    public List<OrderDO> listByCondition(OrderQueryBO queryBO) {
        return orderMapper.selectList(buildWrapper(queryBO));
    }

    /**
     * 新增单条记录
     */
    public int insert(OrderDO entity) {
        return orderMapper.insert(entity);
    }

    /**
     * 根据主键更新
     */
    public int updateById(OrderDO entity) {
        return orderMapper.updateById(entity);
    }

    /**
     * 根据主键删除
     */
    public int deleteById(Long id) {
        return orderMapper.deleteById(id);
    }

    /**
     * 批量新增（逐条插入）
     */
    public int insertBatch(List<OrderDO> entities) {
        int count = 0;
        for (OrderDO entity : entities) {
            count += orderMapper.insert(entity);
        }
        return count;
    }

    /**
     * 根据QueryBO中的非空字段动态构建LambdaQueryWrapper查询条件。
     * 仅对非主键、非审计字段进行条件拼装。
     */
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
