package com.example.order.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单表表实体对象
 *
 * @author codegen
 */
@Table(name="t_order")
public class OrderDO {

    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    /**
     * 订单号
     */
    @Column
    private String orderNo;

    /**
     * 用户ID
     */
    @Column
    private Long userId;

    /**
     * 订单金额
     */
    @Column
    private BigDecimal amount;

    /**
     * 订单状态
     */
    @Column
    private Integer status;

    /**
     * 创建时间
     */
    @Column
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @Column
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
