package com.DesignPattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @Author : liyongjie
 * @Date : 2018/9/5 0005
 */
public class test {

    public static void main(String[] args){
        IFood proxyInstance = (IFood) Proxy.newProxyInstance(KFC.class.getClassLoader(),
                                                                KFC.class.getInterfaces(),
                                                                new ProxyFood(new KFC()));
        proxyInstance.eat();
    }
}
