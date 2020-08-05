package com.jacky.mybatis_plus_demo.controller;


import com.jacky.mybatis_plus_demo.common.ResponseEntity;
import com.jacky.mybatis_plus_demo.common.SuperController;
import com.jacky.mybatis_plus_demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liyongjie
 * @since 2019-01-29
 */
@RestController
@RequestMapping("/user")
public class UserController extends SuperController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam("name") String name,@RequestParam("password") String password, HttpServletRequest request){
        ResponseEntity<Boolean> res = new ResponseEntity();
        boolean b = userService.verifyLogin(name, password);
        if (b){
            request.getSession().setAttribute("LYJ_SESSION",name);
            res.setMessage("login success");
            return res;
        }
        res.setMessage("login failed");
        return res;
    }

    @GetMapping("/loginOut")
    public ResponseEntity<Boolean> loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("LYJ_SESSION");
        ResponseEntity<Boolean> res = new ResponseEntity();
        res.setData(true);
        return res;
    }

}

