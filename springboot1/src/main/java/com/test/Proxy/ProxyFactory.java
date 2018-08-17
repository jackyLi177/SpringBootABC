package com.test.Proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * JDK动态代理,被代理的类必须实现接口，否则不能使用jdk代理
 * @Author : liyongjie
 * @Date : 2018/6/25 0025
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    public Object getNewInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                        System.out.println("JDK  事务开始----->");
                        System.out.println(method.getName());
                        Object result = method.invoke(target,objects);
                        System.out.println("JDK  事务结束----->");
                        return result;
                    }
                }
        );
    }

}
