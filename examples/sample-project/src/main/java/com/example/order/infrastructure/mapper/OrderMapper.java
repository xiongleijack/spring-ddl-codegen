package com.example.order.infrastructure.mapper;

import com.example.order.domain.entity.OrderDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 订单表表Mapper层
 *
 * @author codegen
 */
@Mapper
public interface OrderMapper extends BaseMapper<OrderDO> {

    OrderDO selectByOrderno(@Param("orderNo") String orderNo);
}
