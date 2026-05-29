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
        OrderDO entity = new OrderDO();
        BeanUtils.copyProperties(detailDTO, entity);
        orderDAO.insert(entity);
    }

    @Override
    public void update(Long id, OrderDetailDTO detailDTO) {
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
        OrderQueryBO queryBO = new OrderQueryBO();
        BeanUtils.copyProperties(queryDTO, queryBO);
        Page<OrderDO> page = new Page<>(pageNum, pageSize);
        Page<OrderDO> result = orderDAO.pageQuery(page, queryBO);
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
