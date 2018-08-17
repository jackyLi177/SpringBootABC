package com.test.MongoDB;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.test.Proxy.CGLIBProxy;
import com.test.Proxy.ICrudDao;
import com.test.Proxy.ProxyFactory;
import com.test.Proxy.UserDao;

import java.util.Date;

/**
 * @Author : liyongjie
 * @Date : 2018/6/15 0015
 */
public class Demo {

    public static void main(String... args){

//        MongoClient mongoClient = MongoClients.create();
//        MongoDatabase mydb = mongoClient.getDatabase("mydb");
//        mydb.createCollection("ResultSetUtils");


        UserDao target = new UserDao();
        ProxyFactory f  = new ProxyFactory(target);
        ICrudDao proxyDao = (ICrudDao) f.getNewInstance();
        System.out.println(proxyDao.save("JDK"));
        System.out.println();
        System.out.println();
        System.out.println();

        CGLIBProxy c = new CGLIBProxy(target);
        UserDao u = (UserDao) c.getInstance();
        System.out.println(u.save("CGLIB"));
    }

}
