package com.utah.bookretail.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 用户订单信息表
 */
@Data
@Entity
@Table(name = "tb_user_order")
public class UserOrder {
    /**
     * 订单id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    /**
     * 订单编号
     */
    private String orderNumber;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 交易状态， 0 进行中 ，1 已完成 ，2 取消交易
     */
    private Integer tradeStatus;
    /**
     * 支付状态， 0 待支付，1 已支付
     */
    private Integer payStatus;
    /**
     * 逻辑删除标记，0 未删除 ，1 已删除
     */
    private Integer deleted;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新时间
     */
    private String updateTime;

}
