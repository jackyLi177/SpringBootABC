package com.test;

/**
 * @Author : liyongjie
 * @Date : 2018/7/18 0018
 */
public class DataBase {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public String sayHi(){
        return "Hello World!!!!";
    }

}
