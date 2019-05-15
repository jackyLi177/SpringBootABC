package com.test.SpringBootEvent.TaskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author : lyj
 * @Date : 2018/8/2 0002
 */
@Service
public class TaskExecutorService {

    //标注这是一个异步方法，将会在独立的线程中执行
    //不可以修饰static方法
    // Thread.currentThread().getName() —> ThreadPoolTaskExecutor-1
    @Async
    public void asyncTask(Integer i){
        System.out.println("执行异步任务：   " + i + "---->" + Thread.currentThread().getName());
    }

    // Thread.currentThread().getName() —> main
    public void asyncTask2(Integer i){
        System.out.println("执行异步任务+1：    " + i +" ----> "+ Thread.currentThread().getName());
    }
}
