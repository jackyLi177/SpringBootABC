package com.hengyu.rabbitmq.provider;

import com.hengyu.rabbitmq.common.enums.QueueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列消息提供者启动入口
 * ========================
 *
 * @author 恒宇少年
 * Created with IntelliJ IDEA.
 * Date：2017/11/26
 * Time：14:14
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@SpringBootApplication
@Configuration
public class RabbitmqProviderApplication
{
    static Logger logger = LoggerFactory.getLogger(RabbitmqProviderApplication.class);

    /**
     * 消息队列提供者启动入口
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(RabbitmqProviderApplication.class,args);

        logger.info("【【【【【消息队列-消息提供者启动成功.】】】】】");
    }

}
