package com.test.Proxy;

/**
 * @Author : liyongjie
 * @Date : 2018/7/6 0006
 */
public class test {

    public static void main(String[] args){
        UserDao userDao = new UserDao();
        ProxyFactory JDKDao = new ProxyFactory(userDao);
        ICrudDao jdk = (ICrudDao) JDKDao.getNewInstance();
        CGLIBProxy CGLIBDao = new CGLIBProxy(userDao);
        ICrudDao cglib = (ICrudDao) CGLIBDao.getInstance();
        jdk.save("jdk");
        cglib.save("cglib");
    }

}
