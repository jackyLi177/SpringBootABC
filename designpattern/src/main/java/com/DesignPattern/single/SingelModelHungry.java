package com.DesignPattern.single;

/**
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class SingelModelHungry {

    private SingelModelHungry(){}

    /**
     * 静态资源（静态代码块，静态变量，静态方法）静态变量只有在类加载的时候初始化一次，因此这个是线程安全的
     */
    private static SingelModelHungry singelModelHungry = new SingelModelHungry();

    public static SingelModelHungry getInstance(){
        return singelModelHungry;
    }

}
