package com.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author ：lyj
 * @date ：2019/5/5 14:05
 */
@Component
public class Init_2 implements ApplicationRunner, Ordered {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
        System.out.println("初始化222222222");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
