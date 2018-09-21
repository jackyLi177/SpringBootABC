package com.DesignPattern.abstractFactory;

/**
 * @Author : liyongjie
 * @Date : 2018/9/3 0003
 */
public class mcFactory implements Ifactory{
    public IChicken createChicken() {
        return new mcChicken();
    }

    public IChip createChip() {
        return new mcChip();
    }
}
