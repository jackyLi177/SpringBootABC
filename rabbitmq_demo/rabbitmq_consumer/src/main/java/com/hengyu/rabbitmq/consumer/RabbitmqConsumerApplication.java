package com.hengyu.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 消息队列消息消费者入口
 * ========================
 */
@SpringBootApplication
@ComponentScan(value = "com.hengyu.rabbitmq")
public class RabbitmqConsumerApplication
{
    static Logger logger = LoggerFactory.getLogger(RabbitmqConsumerApplication.class);

    /**
     * rabbitmq消费者启动入口
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(RabbitmqConsumerApplication.class,args);

        logger.info("【【【【【消息队列-消息消费者启动成功.】】】】】");
    }
}
