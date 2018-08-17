package com.test.Proxy;

/**
 * @Author : liyongjie
 * @Date : 2018/6/25 0025
 */
public class UserDao implements ICrudDao {
    @Override
    public int save(String name) {
        System.out.println("name == "+name);
        return 99999;
    }
}
