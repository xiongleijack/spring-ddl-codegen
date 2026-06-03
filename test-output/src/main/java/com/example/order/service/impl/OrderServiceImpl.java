package com.example.order.service.impl;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.google.common.collect.Lists;
import com.innodealing.commons.object.BeanCopyUtils;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.order.service.OrderService;
import com.example.order.model.bo.OrderQueryBO;
import com.example.order.model.dto.OrderDetailDTO;
import com.example.order.model.dto.request.OrderQueryDTO;
import com.example.order.model.dto.response.OrderPageDTO;
import com.example.order.model.entity.bondbasic.OrderDO;
import com.example.order.dao.bondbasic.OrderDAO;

/**
 * 订单表表Service实现层 {@link OrderDO}
 *
 * @author xionglei
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private OrderDAO orderDAO;

    @Override
    public void insertOrder(Long userId, OrderDetailDTO orderDetailDTO) {
        OrderDO orderDO =
                BeanCopyUtils.copyProperties(orderDetailDTO, OrderDO.class);
        checkOrderExist(orderDO);
        orderDO.setCreateBy(userId);
        orderDO.setUpdateBy(userId);
        orderDO.setDeleted(0);
        orderDAO.insertBatchOrderDOs(userId, Lists.newArrayList(orderDO));
    }

    @Override
    public void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted) {
        orderDAO.updateDeletedByIds(userId, ids, deleted);
    }

    @Override
    public void updateOrder(Long userId, OrderDetailDTO orderDetailDTO) {
        OrderDO orderDO =
                BeanCopyUtils.copyProperties(orderDetailDTO, OrderDO.class);
        checkOrderExist(orderDO);
        orderDO.setUpdateBy(userId);
        orderDAO.updateBatchOrderDOsByPrimaryKey(userId, Lists.newArrayList(orderDO));
    }

    private void checkOrderExist(OrderDO orderDO) {
        Map<String, Long> businessKeyToIdMap = orderDAO.getBusinessKeyToIdMap(Lists.newArrayList(orderDO));
        String businessKey = orderDAO.getBusinessKey(orderDO);
        Long existId = businessKeyToIdMap.get(businessKey);
        if (!(Objects.isNull(businessKeyToIdMap.get(businessKey)) || Objects.equals(existId, orderDO.getId()))) {
            throw new RuntimeException("业务主键数据重复,请检查数据!");
        }
    }

    @Override
    public OrderDetailDTO getOrderById(Long id) {
        return orderDAO.getOrderDOById(id)
                .map(orderDO -> BeanCopyUtils.copyProperties(orderDO, OrderDetailDTO.class))
                .orElseGet(() -> {
                    logger.warn("db data not found by id: {}", id);
                    return null;
                });
    }

    @Override
    public NormPagingResult<OrderPageDTO> pageQuery(
            OrderQueryDTO orderQueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection) {
        OrderQueryBO orderQueryBO =
                BeanCopyUtils.copyProperties(orderQueryDTO, OrderQueryBO.class);
        NormPagingResult<OrderDO> pagingResult =
                orderDAO.pageQuery(orderQueryBO, pageSize, pageNum, sortProperty, sortDirection);
        List<OrderPageDTO> pageDTOList = pagingResult.getList().stream()
                .map(orderDO -> {
                    OrderPageDTO orderPageDTO =
                            BeanCopyUtils.copyProperties(orderDO, OrderPageDTO.class);
                    return orderPageDTO;
                })
                .collect(Collectors.toList());
        NormPagingResult<OrderPageDTO> normPagingResult = new NormPagingResult<>();
        BeanCopyUtils.copyProperties(pagingResult, normPagingResult);
        normPagingResult.setList(pageDTOList);
        return normPagingResult;
    }
}
