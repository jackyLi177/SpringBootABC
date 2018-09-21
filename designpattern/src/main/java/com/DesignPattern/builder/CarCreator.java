package com.DesignPattern.builder;

/**
 * 本例建造者模式指挥者角色
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class CarCreator implements ICreator{

    /**
     * 初始化建造者对象
     */
    private CarBuilder builder;

    public CarCreator(CarBuilder builder){
        this.builder = builder;
    }

    public Car createCar() {
        Car car = new Car();
        Engine engine = builder.buildeEngine();
        Tyre tyre = builder.buildTyre();
        car.setEngine(engine);
        car.setTyre(tyre);
        return car;
    }
}
