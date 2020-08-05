package com.test.SpringBootEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Author : liyongjie
 * @Date : 2018/8/2 0002
 */
@Component
public class DemoPublisher {

    //使用ApplicationContext发布事件
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg){
        applicationContext.publishEvent(new DemoEvent(this,msg));
    }
}
