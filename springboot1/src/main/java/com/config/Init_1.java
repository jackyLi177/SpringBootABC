package com.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author ：lyj
 * @date ：2019/5/5 14:03
 */
@Component
public class Init_1 implements CommandLineRunner, Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(args);
        System.out.println("初始化111111111");
    }
}
