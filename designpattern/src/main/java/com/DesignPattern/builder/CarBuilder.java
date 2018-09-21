package com.DesignPattern.builder;

/**
 * 本例建造者模式具体建造者角色，实现抽象建造者接口
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class CarBuilder implements IBuilder{
    public Engine buildeEngine() {
        return new Engine("宝马发动机");
    }

    public Tyre buildTyre() {
        return new Tyre("米其林轮胎");
    }
}
