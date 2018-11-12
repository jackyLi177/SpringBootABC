package com.jacky.quartzdemo.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.ParameterizedType;
import java.util.Date;

/**
 * @Author : liyongjie
 * @Date : 2018/10/23 0023
 */
public class GoodAddTimer extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("22222添加商品任务执行--------------------》 "+new Date());
    }

    public <T> void sss(T t){
        Class aClass =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        System.out.println(aClass.toString());
    }

    public static void main(String[] args){
        GoodAddTimer d = new GoodAddTimer();
        d.sss(d);
    }
}
