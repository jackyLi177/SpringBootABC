package com.jacky.quartzdemo.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Author : liyongjie
 * @Date : 2018/10/23 0023
 */
public class GoodStockCheckTimer extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("库存检查执行---------------------》:{}"+new Date());
    }
}
