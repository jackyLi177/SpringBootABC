package com.DesignPattern.builder;

/**
 * 本例建造者模式的抽象建造者角色
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public interface IBuilder {
    Engine buildeEngine();

    Tyre buildTyre();
}
