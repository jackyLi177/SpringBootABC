package com.jacky.jwtdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author : lyj
 * @Date : 2018/8/21 0021
 */
@Configuration
public class JWTConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyJWTInterceptor()).addPathPatterns("/api/*");
    }
}
