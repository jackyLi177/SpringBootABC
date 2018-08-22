package com.jacky.jwtdemo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author : liyongjie
 * @Date : 2018/8/21 0021
 */
@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }
}
