package com.DesignPattern.abstractFactory;

/**
 * 肯德基工厂实现类，生产肯德基的鸡翅和薯条（一个工厂类可以产生多个产品）
 * @Author : liyongjie
 * @Date : 2018/9/3 0003
 */
public class kfcFactory implements Ifactory{
    public IChicken createChicken() {
        return new kfcChicken();
    }

    public IChip createChip() {
        return new kfcChip();
    }
}
