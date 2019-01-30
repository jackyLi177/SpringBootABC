package com.jacky.mybatis_plus_demo.controller;


import com.jacky.mybatis_plus_demo.entity.Home;
import com.jacky.mybatis_plus_demo.service.HomeService;
import com.jacky.mybatis_plus_demo.service.impl.HomeServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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

    @PostMapping
    @ApiOperation(value = "",httpMethod = "POST")
    public Object addHome(@RequestBody Home home){
        homeService.insert(home);
        return home.getId();
    }



}

