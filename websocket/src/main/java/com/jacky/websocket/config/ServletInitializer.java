package com.jacky.websocket.config;

import com.jacky.websocket.WebsocketApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author : liyongjie
 * @Date : 2018/9/21 0021
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebsocketApplication.class);
    }

}
