package com.DesignPattern.abstractFactory;

/**
 * 抽象工厂类，可以产生多个具体的工厂类，本例产生肯德基麦当劳两家工厂
 * @Author : liyongjie
 * @Date : 2018/9/3 0003
 */
public interface Ifactory {

    IChicken createChicken();

    IChip createChip();

}
