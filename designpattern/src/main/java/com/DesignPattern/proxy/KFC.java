package com.DesignPattern.proxy;

/**
 * @Author : liyongjie
 * @Date : 2018/9/5 0005
 */
public class KFC implements IFood{
    public void eat() {
        System.out.println("吃了肯德基");
    }

    public void make() {
        System.out.println("烹饪");
    }
}
