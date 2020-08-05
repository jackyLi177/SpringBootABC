package com.hengyu.rabbitmq.consumer.user;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册消息消费者
 * ========================
 */
@Component
@RabbitListener(queues = "user.register.queue")
public class UserConsumer {

    @RabbitHandler
    public void execute(Long userId)
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用户：" + userId+"，完成了注册");

        //...//自行业务逻辑处理
    }
}
