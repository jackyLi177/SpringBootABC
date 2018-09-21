package com.DesignPattern.builder;

/**
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class Engine {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine(String name){
        this.name = name;
    }
}
