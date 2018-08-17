package com.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * @author liyongjie
 * @date 2018年5月17日
 */
@Slf4j
@Aspect
@Component
public class AOPConfig {
	
	//ThreadLocal 解决基本类型同步问题
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	@Pointcut("execution(public boolean com.controller..*(..))")
	public void aopDemo(){log.info("aopDemo()-----------------<");}
	
	@Before(value = "aopDemo()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		
		ServletRequestAttributes context = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = context.getRequest();
		log.info("URL---->"+request.getRequestURL().toString());
		log.info("SERVERPort--->"+request.getServerPort());
		log.info("ContentType---->"+request.getContentType());
		log.info("ContentPath---->"+request.getContextPath());
		log.info("ENCODING---->"+request.getCharacterEncoding());
		log.info("METHOD---->"+request.getMethod());
		log.info("IP---->"+request.getRemoteAddr());
		log.info("HOST---->"+request.getRemoteHost());
		log.info("REMO PORT---->"+request.getRemotePort());
		log.info("CLASS METHOD---->"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
		log.info("ARGS---->"+Arrays.toString(joinPoint.getArgs()));
		
		
		startTime.set(System.currentTimeMillis());
		log.info("doBefore-----------------------------<");
	}
	
//	@After("aopDemo()")
//	public void doAfter(){
//		log.info("doAfter-----------------------------<");
//	}
//	
//	/**
//	 * 环绕切点执行，如果写了@Around，就必须写完整（proceed方法必须写出来），否则进入不了@before，@around执行于@Before之前
//	 * @param pjp
//	 * @throws Throwable
//	 */
//	@Around(value = "aopDemo()")
//	public void doAround(ProceedingJoinPoint pjp) throws Throwable{
//		log.info("doAroundBefore-----------------------------<");
//		pjp.proceed();
//		log.info("doAroundAfter-----------------------------<");
//	}
//	
//	@AfterReturning(returning="ret",pointcut="aopDemo()")
//	public void doAfterReturn(Object ret){
//		log.info("curTime=="+System.currentTimeMillis());
//		log.info("startTime=="+startTime.get());
//		log.info("SPEND TIME=="+(System.currentTimeMillis() - startTime.get().longValue()));
//		log.info("doAfterReturn-----------------------------<");
//	}
//	
//	@AfterThrowing(pointcut="aopDemo()")
//	public void doAfterThrowing(JoinPoint joinPoint){
//		log.info("doAfterThrowing-----------------------------<");
//	}
}
