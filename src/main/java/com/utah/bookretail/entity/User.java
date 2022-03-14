package com.utah.bookretail.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 用户信息表
 */
@Data
@Entity
@Table(name = "tb_user")
public class User {

    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户积分
     */
    private BigDecimal points;
    /**
     * 会员级别，1 Coper，2 Silver ，3 Gold
     */
    private Integer memberTypeId;
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
