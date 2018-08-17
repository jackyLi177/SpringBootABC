package com.config;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.core.annotation.Order;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liyongjie
 * @date 2018年5月18日
 */
@Slf4j
//@WebFilter(filterName="MyFilter",urlPatterns="/*")
//@Order(2) //设置spring  bean 的加载顺序（未实验）,不代表Filter的优先级
public class Myfilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter1 Init-------------->");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("Filter1 processing----------->");
		chain.doFilter(request, response);
		/*log.info("URL---->"+request.getProtocol());
		log.info("SERVERPort--->"+request.getServerPort());
		log.info("ContentType---->"+request.getContentType());
		log.info("ENCODING---->"+request.getCharacterEncoding());
		log.info("IP---->"+request.getRemoteAddr());
		log.info("HOST---->"+request.getRemoteHost());
		log.info("REMO PORT---->"+request.getRemotePort());*/
	}

	/**
	 * 停止项目是过滤器销毁
	 */
	@Override
	public void destroy() {
		log.info("Filter1 destory----------------->");
	}

}
