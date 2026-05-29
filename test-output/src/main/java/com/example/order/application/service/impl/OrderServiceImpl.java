package com.example.order.application.service.impl;

import com.example.order.api.dto.OrderDetailDTO;
import com.example.order.api.dto.OrderPageDTO;
import com.example.order.api.dto.OrderQueryDTO;
import com.example.order.application.service.OrderService;
import com.example.order.domain.bo.OrderQueryBO;
import com.example.order.domain.entity.OrderDO;
import com.example.order.infrastructure.dao.OrderDAO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单表表Service实现层
 *
 * @author codegen
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDAO orderDAO;

    @Override
    public void create(OrderDetailDTO detailDTO) {
        // DTO -> DO 转换后插入数据库
        OrderDO entity = new OrderDO();
        BeanUtils.copyProperties(detailDTO, entity);
        orderDAO.insert(entity);
    }

    @Override
    public void update(Long id, OrderDetailDTO detailDTO) {
        // DTO -> DO 转换，设置主键后更新
        OrderDO entity = new OrderDO();
        BeanUtils.copyProperties(detailDTO, entity);
        entity.setId(id);
        orderDAO.updateById(entity);
    }

    @Override
    public void delete(Long id) {
        orderDAO.deleteById(id);
    }

    @Override
    public OrderDetailDTO getDetail(Long id) {
        // 查询DO并转换为DetailDTO返回，不存在则返回null
        return orderDAO.getById(id)
                .map(entity -> {
                    OrderDetailDTO dto = new OrderDetailDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .orElse(null);
    }

    @Override
    public Page<OrderPageDTO> pageQuery(OrderQueryDTO queryDTO, Integer pageNum, Integer pageSize) {
        // 1. QueryDTO -> QueryBO 转换
        OrderQueryBO queryBO = new OrderQueryBO();
        BeanUtils.copyProperties(queryDTO, queryBO);
        // 2. 执行分页查询
        Page<OrderDO> page = new Page<>(pageNum, pageSize);
        Page<OrderDO> result = orderDAO.pageQuery(page, queryBO);
        // 3. DO列表 -> PageDTO列表 转换
        Page<OrderPageDTO> pageResult = new Page<>(result.getCurrent(), result.getSize(), result.getTotal());
        List<OrderPageDTO> records = result.getRecords().stream()
                .map(entity -> {
                    OrderPageDTO dto = new OrderPageDTO();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                })
                .collect(Collectors.toList());
        pageResult.setRecords(records);
        return pageResult;
    }
}
