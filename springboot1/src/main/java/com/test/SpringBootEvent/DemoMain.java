package com.test.SpringBootEvent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * @Author : liyongjie
 * @Date : 2018/8/2 0002
 */
public class DemoMain {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

//        DemoPublisher bean = context.getBean(DemoPublisher.class);
//        bean.publish("Demo Event....................");
//        AwareService bean1 = context.getBean(AwareService.class);
//        bean1.outPutResult();
//        TaskExecutorService bean = context.getBean(TaskExecutorService.class);
//        for(int i =1;i<=10;i++){
//            bean.asyncTask(i);
//            bean.asyncTask2(i);
//        }
        MutablePropertySources s = context.getEnvironment().getPropertySources();
        Iterator<PropertySource<?>> iterator = s.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
        System.out.println(s);
        context.close();
    }

}
