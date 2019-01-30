package com.jacky.mybatis_plus_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
public class WebMVCConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(getIntersector());
        /**
         * 拦截路径
         */
        interceptorRegistration.addPathPatterns("/home/*");

        /**
         * 忽略路径
         */
        interceptorRegistration.excludePathPatterns(new String[]{"/error","/login"});
        super.addInterceptors(registry);
    }

    public HandlerInterceptorAdapter getIntersector(){
        return new MyInterceptor();
    }
}
