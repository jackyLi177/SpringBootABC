package com.jacky.mybatis_plus_demo.controller;


import com.jacky.mybatis_plus_demo.entity.Home;
import com.jacky.mybatis_plus_demo.service.HomeService;
import com.jacky.mybatis_plus_demo.service.impl.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  &#x524d;&#x7aef;&#x63a7;&#x5236;&#x5668;
 * </p>
 *
 * @author liyongjie
 * @since 2019-01-29
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeServiceImpl homeService;

    @GetMapping("/test")
    public String test(){
        return "mmmmmmm";
    }

    @GetMapping("/{id}")
    public Home getHome(@PathVariable Integer id){
        return homeService.selectById(id);
    }

}

