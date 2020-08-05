package com.jacky.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @Author : liyongjie
 * @Date : 2018/9/21 0021
 */
@Configuration
@EnableWebSocketMessageBroker   //开启使用STOMP协议来传输消息
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * 实现了registerStompEndpoints方法添加了对应的STOMP使用SockJS协议
     *
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointJacky").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
