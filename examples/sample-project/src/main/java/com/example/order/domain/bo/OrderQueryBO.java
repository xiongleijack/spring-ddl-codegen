package com.example.order.domain.bo;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表表查询业务对象
 *
 * @author codegen
 */
@Data
public class OrderQueryBO {

    private String orderNo;

    private Long userId;

    private BigDecimal amount;

    private Integer status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
