package com.example.order.model.bo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.sql.Timestamp;

/**
 * 订单表表查询业务对象
 *
 * @author xionglei
 */
public class OrderQueryBO {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 订单金额
     */
    private BigDecimal amount;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
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
