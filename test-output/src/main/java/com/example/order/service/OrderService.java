package com.example.order.service;

import com.github.wz2cool.dynamic.SortDirection;
import com.github.wz2cool.dynamic.model.NormPagingResult;
import com.example.order.model.dto.OrderDetailDTO;
import com.example.order.model.dto.request.OrderQueryDTO;
import com.example.order.model.dto.response.OrderPageDTO;
import com.example.order.model.entity.bondbasic.OrderDO;

import java.util.Collection;

/**
 * 订单表表Service层 {@link OrderDO}
 *
 * @author xionglei
 */
public interface OrderService {

    /**
     * 新增数据处理
     *
     * @param userId              用户id
     * @param orderDetailDTO 用户请求对象
     */
    void insertOrder(Long userId, OrderDetailDTO orderDetailDTO);

    /**
     * 更新deleted字段
     *
     * @param userId  用户id
     * @param ids     主键集合
     * @param deleted 删除状态
     */
    void updateDeletedByIds(Long userId, Collection<Long> ids, Integer deleted);

    /**
     * 更新数据
     *
     * @param userId              用户id
     * @param orderDetailDTO 请求对象
     */
    void updateOrder(Long userId, OrderDetailDTO orderDetailDTO);

    /**
     * 根据主键获取数据
     *
     * @param id 主键
     * @return 数据
     */
    OrderDetailDTO getOrderById(Long id);

    /**
     * 分页查询
     *
     * @param orderQueryDTO 查询条件
     * @param pageSize             每页大小
     * @param pageNum              当前页
     * @param sortProperty         排序字段
     * @param sortDirection        排序方向
     * @return 分页结果
     */
    NormPagingResult<OrderPageDTO> pageQuery(
            OrderQueryDTO orderQueryDTO, Integer pageSize,
            Integer pageNum, String sortProperty, SortDirection sortDirection);
}
