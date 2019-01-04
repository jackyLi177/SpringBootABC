package com.test;

/**
 * @Author : liyongjie
 * @Date : 2018/12/04
 */
public class InitSeq {

    static{
        System.out.println("这是静态代码块");
    }

    {
        System.out.println("这是普通代码块");
    }

    public static void method(){
        System.out.println("这是一个静态方法");
    }

    public void method2(){
        System.out.println("这是一个普通方法");
    }

    public InitSeq(){
        System.out.println("这是一个无参构造方法");
    }


    public static void main(String[] args) {
        InitSeq i = new InitSeq();
        InitSeq.method();
    }


}
