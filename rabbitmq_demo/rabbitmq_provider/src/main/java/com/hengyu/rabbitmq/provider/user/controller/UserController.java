package com.hengyu.rabbitmq.provider.user.controller;

import com.hengyu.rabbitmq.provider.user.entity.UserEntity;
import com.hengyu.rabbitmq.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 用户控制器
 * ========================
 */
@RestController
@RequestMapping(value = "/user")
public class UserController
{
    /**
     * 用户业务逻辑
     */
    @Autowired
    private UserService userService;

    public static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(10,20,3000, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(5));

    /**
     * 保存用户基本信息
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public UserEntity save(@RequestBody UserEntity userEntity) throws Exception
    {
        userService.save(userEntity);
        return userEntity;
    }

    @GetMapping("/batchSave")
    public String batchSave(){
        for (int i = 0; i < 10; i++) {

            EXECUTOR.execute(() -> {
                Random random = new Random();
                int ran = random.nextInt() * 10;
                double balance = random.nextDouble() * 100000;
                UserEntity userEntity = new UserEntity("userName" + ran, "name" + ran, 18 + ran, new BigDecimal(balance));
                try {
                    Thread.sleep(3000);
                    userService.save(userEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        return "sucess";
    }
}
