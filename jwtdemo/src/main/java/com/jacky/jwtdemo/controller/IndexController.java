package com.jacky.jwtdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : liyongjie
 * @Date : 2018/8/21 0021
 */
@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "Success!!";
    }

}
