package com.jacky.mybatis_plus_demo.controller;


import com.jacky.mybatis_plus_demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2019-01-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper mapper;

    @GetMapping("/test")
    public String get(Integer id){
        return mapper.selectById(new Integer(id)).toString();
    }
}

