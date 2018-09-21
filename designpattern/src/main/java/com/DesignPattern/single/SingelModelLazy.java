package com.DesignPattern.single;

/**
 * 懒汉式，使用的时候再创建对象
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class SingelModelLazy {

    /**
     * 构造函数私有
     */
    private SingelModelLazy(){}

    private static SingelModelLazy singelModel;

    /**
     * 线程不安全
     * @return
     */
    public static SingelModelLazy getInstance(){
        if (singelModel == null) {
            return new SingelModelLazy();
        }
        return singelModel;
    }

    /**
     * 线程安全，但是浪费资源
     * @return
     */
    public synchronized static SingelModelLazy getSingelModel(){
        if (singelModel == null) {
            return new SingelModelLazy();
        }
        return singelModel;
    }

    /**
     * 它与饿汉模式一样，也是利用了类加载机制，因此不存在多线程并发的问题。
     * 不一样的是，它是在内部类里面去创建对象实例。这样的话，只要应用中不使用内部类，
     * JVM就不会去加载这个单例类，也就不会创建单例对象，从而实现懒汉式的延迟加载。
     * 也就是说这种方式可以同时保证延迟加载和线程安全。
     */
    private static class InnerClass{
        private static SingelModelLazy instance = new SingelModelLazy();
    }

    public static SingelModelLazy getInnerInstance(){
        return InnerClass.instance;
    }
}
