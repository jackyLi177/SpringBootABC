package com.test.SpringBootEvent.TaskExecutor;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.VoidType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author : liyongjie
 * @Date : 2018/8/2 0002
 */
@Service
public class TaskExecutorService {

    @Async
    public void asyncTask(Integer i){
        System.out.println("执行异步任务：   " +i+"---->"+Thread.currentThread().getName());
    }

    public void asyncTask2(Integer i){
        System.out.println("执行异步任务+1：    " +(i+1)+"---->"+Thread.currentThread().getName());
    }
}
