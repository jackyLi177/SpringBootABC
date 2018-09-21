package com.jacky.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author : liyongjie
 * @Date : 2018/9/21 0021
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
    }

    /**
     * 等于在application.properties里配置
     * spring.mvc.view.prefix=/WEB-INF/jsp/
     * spring.mvc.view.suffix=.jsp
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("webapp/WEB-INF/jsp/",".jsp");
    }



















    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
                .allowedOrigins("*")  //允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
                .allowedMethods("PUT", "DELETE", "GET", "POST") //允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
                .allowedHeaders("*") //允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
                .exposedHeaders(
                        "access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .allowCredentials(true)  ////是否带上cookie
                .maxAge(3600);
    }
}
