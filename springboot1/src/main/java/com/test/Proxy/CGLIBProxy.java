package com.test.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author : liyongjie
 * @Date : 2018/6/25 0025
 */
public class CGLIBProxy implements MethodInterceptor{

    private Object target;
    public CGLIBProxy(Object target){
        this.target = target;
    }

    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 事务开启---->");
        System.out.println(method.getName());
        Object result = method.invoke(target,objects);
        System.out.println("cglib 事务关闭---->");
        return result;
    }
}
