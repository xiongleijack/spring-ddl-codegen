package com.example.order.application.service;

import com.example.order.api.dto.OrderDetailDTO;
import com.example.order.api.dto.OrderPageDTO;
import com.example.order.api.dto.OrderQueryDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 订单表表Service层
 *
 * @author codegen
 */
public interface OrderService {

    /**
     * 新增
     *
     * @param detailDTO 详情对象
     */
    void create(OrderDetailDTO detailDTO);

    /**
     * 更新
     *
     * @param id        主键
     * @param detailDTO 详情对象
     */
    void update(Long id, OrderDetailDTO detailDTO);

    /**
     * 删除
     *
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 根据主键查询详情
     *
     * @param id 主键
     * @return 详情对象
     */
    OrderDetailDTO getDetail(Long id);

    /**
     * 分页查询
     *
     * @param queryDTO 查询条件
     * @param pageNum  页码
     * @param pageSize 每页大小
     * @return 分页结果
     */
    Page<OrderPageDTO> pageQuery(OrderQueryDTO queryDTO, Integer pageNum, Integer pageSize);
}
