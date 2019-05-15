package com.test.SpringBootEvent;

import com.test.SpringBootEvent.TaskExecutor.TaskExecutorService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author : liyongjie
 * @Date : 2018/8/2 0002
 */
public class DemoMain {

    public static void main(String[] args){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        DemoPublisher bean = context.getBean(DemoPublisher.class);
        bean.publish("Demo Event....................");
        AwareService bean1 = context.getBean(AwareService.class);
        bean1.outPutResult();
        TaskExecutorService executorService = context.getBean(TaskExecutorService.class);
        for(int i =1;i<=10;i++){
            executorService.asyncTask(i);
            executorService.asyncTask2(i);
        }
//        MutablePropertySources s = context.getEnvironment().getPropertySources();
//        Iterator<PropertySource<?>> iterator = s.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().getName());
//        }
//        System.out.println(s);
//        context.close();
    }

}
