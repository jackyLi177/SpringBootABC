package com.jacky.globalconf;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author: Liyj
 * @date: 2020-04-01 11:29
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public BigDecimal test(){
        BigDecimal num = new BigDecimal("10.90000");
        return num;
    }

}
