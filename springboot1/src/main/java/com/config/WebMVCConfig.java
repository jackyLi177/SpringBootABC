package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyongjie
 * @date 2018年5月18日
 */
@Configuration
public class WebMVCConfig {

	@Bean
	public FilterRegistrationBean configureFilter1(){
		FilterRegistrationBean bean = new FilterRegistrationBean<>();
		bean.setName("filter1");
		Myfilter myfilter = new Myfilter();
		bean.setFilter(myfilter);
		bean.setOrder(1);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		bean.setUrlPatterns(urlList);
		return bean;
	}
	
	@Bean
	public FilterRegistrationBean configureFilter2(){
		FilterRegistrationBean bean = new FilterRegistrationBean<>();
		bean.setName("filter2");
		MyFilter2 myfilter2 = new MyFilter2();
		bean.setFilter(myfilter2);
		bean.setOrder(2);
		List<String> urlList = new ArrayList<String>();
		urlList.add("/*");
		bean.setUrlPatterns(urlList);
		return bean;
	}
}
