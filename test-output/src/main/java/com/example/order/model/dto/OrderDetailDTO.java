package com.example.order.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单表表Detail对象 {@link OrderDO}
 *
 * @author xionglei
 */
public class OrderDetailDTO {

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("订单号")
    private String orderNo;

    @ApiModelProperty("用户ID")
    private Long userId;

    @ApiModelProperty("订单金额")
    private BigDecimal amount;

    @ApiModelProperty("订单状态")
    private Integer status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createdAt;

    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderNo;
    }

    public void setOrderno(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getUserid() {
        return userId;
    }

    public void setUserid(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreatedat() {
        return createdAt;
    }

    public void setCreatedat(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedat() {
        return updatedAt;
    }

    public void setUpdatedat(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
