package com.hengyu.rabbitmq.common.configuration;

import com.hengyu.rabbitmq.common.enums.ExchangeEnum;
import com.hengyu.rabbitmq.common.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户注册消息队列配置
 * ========================
 * @author 恒宇少年
 * Created with IntelliJ IDEA.
 * Date：2017/11/26
 * Time：16:58
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Configuration
public class UserRegisterQueueConfiguration {

    @Autowired
    private Queue userRegisterQueue;

    /**
     * 配置路由交换对象实例
     * @return
     */
    @Bean
    public DirectExchange userRegisterDirectExchange()
    {
        return new DirectExchange(ExchangeEnum.USER_REGISTER.getValue());
    }

    /**
     * 配置用户注册队列对象实例
     * 并设置持久化队列
     * @return
     */
    @Bean
    public Queue userRegisterQueue()
    {
        return new Queue(QueueEnum.USER_REGISTER.getName(),true);
    }

    /**
     * 将用户注册队列绑定到路由交换配置上并设置指定路由键进行转发
     * @return
     */
    @Bean
    public Binding userRegisterBinding()
    {
        return BindingBuilder
                .bind(userRegisterQueue)   //绑定消息队列
                .to(userRegisterDirectExchange())  //绑定交换路由
                .with(QueueEnum.USER_REGISTER.getRoutingKey());  //指定路由键
    }
}
