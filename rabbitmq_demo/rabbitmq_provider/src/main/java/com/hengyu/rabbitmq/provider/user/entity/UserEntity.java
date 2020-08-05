package com.hengyu.rabbitmq.provider.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 用户实体
 * ========================
 */
@Data
@Table(name = "user_info")
@Entity
public class UserEntity
    implements Serializable
{
    /**
     * 用户编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UI_ID")
    private Long id;
    /**
     * 用户名称
     */
    @Column(name = "UI_USER_NAME")
    private String userName;
    /**
     * 姓名
     */
    @Column(name = "UI_NAME")
    private String name;
    /**
     * 年龄
     */
    @Column(name = "UI_AGE")
    private int age;
    /**
     * 余额
     */
    @Column(name = "UI_BALANCE")
    private BigDecimal balance;

    public UserEntity(String userName, String name, int age, BigDecimal balance) {
        this.userName = userName;
        this.name = name;
        this.age = age;
        this.balance = balance;
    }
}
