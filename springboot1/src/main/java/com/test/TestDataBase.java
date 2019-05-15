package com.test;

/**
 * @Author : lyj
 * @Date : 2018/7/18 0018
 */
public class TestDataBase {

    //setter注入
    private DataBase dataBase;
    public void setDataBase(DataBase db){
        this.dataBase = db;
    }

    public void getMsg(){
        System.out.println(dataBase.sayHi());
    }
}
