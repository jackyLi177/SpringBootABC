package com.DesignPattern.builder;

/**
 * 本例建造者模式的产品角色
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class Car {
    private Engine engine;
    private Tyre tyre;

    /*public Car(Engine engine, Tyre tyre) {
        this.engine = engine;
        this.tyre = tyre;
    }*/

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
}
