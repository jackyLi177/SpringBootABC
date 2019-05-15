package com.jacky.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * kafka生产者
 * @author ：lyj
 * @date ：2019/5/14 16:53
 */
@Component
//@EnableScheduling
public class MyKafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

//    @Scheduled(cron = "00/1 * * * * ?")
    public void send(String message){
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("test", message);
        future.addCallback( o -> System.out.println("消息发送成功" + message),f -> System.out.println("消息发送失败" + message));
    }

}
