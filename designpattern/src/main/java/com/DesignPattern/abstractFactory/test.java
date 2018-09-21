package com.DesignPattern.abstractFactory;

/**
 *     我们举一个麦当劳和肯德基的例子，他们两家中都买薯条和鸡翅，那么薯条和鸡翅就是两类产品，
 *     麦当劳和肯德基就是具体的工厂类用来生产薯条和鸡翅，那么我们需要一个抽象的工厂类来生产这两类产品，
 * 肯德基和麦当劳只需要实现即可。
 * @Author : liyongjie
 * @Date : 2018/9/3 0003
 */
public class test {

    public static void main(String[] args){
        kfcFactory kfc = new kfcFactory();
        kfc.createChicken().eat();
        kfc.createChip().eat();
        mcFactory mc = new mcFactory();
        mc.createChicken().eat();
        mc.createChip().eat();

        System.out.println("901".matches("[0-8,;]+"));
    }

}
