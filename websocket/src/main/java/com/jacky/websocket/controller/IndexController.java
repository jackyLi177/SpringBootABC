package com.jacky.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : liyongjie
 * @Date : 2018/9/21 0021
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "hello";
    }

}
