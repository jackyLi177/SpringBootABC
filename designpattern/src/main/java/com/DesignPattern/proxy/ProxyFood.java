package com.DesignPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author : liyongjie
 * @Date : 2018/9/5 0005
 */
public class ProxyFood implements InvocationHandler {
    private Object realObject;

    public ProxyFood(Object obj){
        this.realObject = obj;
    }

    public void preInvoke(){
        System.out.println("饭前洗手-------------->");
    }

    public void postInvoke(){
        System.out.println("饭后散步--------------->");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());

        this.preInvoke();
        Object o = method.invoke(realObject, args);
        this.postInvoke();
        return o;
    }
}
