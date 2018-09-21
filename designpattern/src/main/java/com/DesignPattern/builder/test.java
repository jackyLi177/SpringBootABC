package com.DesignPattern.builder;

/**
 * 建造者模式
 *      1.产品角色
 *      2.抽象建造者
 *      3.具体建造者
 *      4.指挥者
 * 指挥者负责按需求调用建造者的方法构建产品所需的部件
 *   举个例子：场景->肯德基点餐 ==
 *             顾客需要的套餐是产品，点餐系统是指挥者，厨师是具体建造者。
 *             每位顾客去肯德基点餐都是不一样的，这个时候点餐系统就会通知厨师，让厨师制作顾客需要的单品，
 *             如build鸡翅，build可乐，build薯条等，然后构建顾客所需的套餐（产品角色）
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class test {
    public static void main(String[] args){
        CarCreator creator = new CarCreator(new CarBuilder());
        Car car = creator.createCar();
        System.out.println(car.getEngine().getName());
        System.out.println(car.getTyre().getName());
    }
}
