package com.jacky.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author ：lyj
 * @date ：2019/5/15 10:37
 */
@Component
public class MyKafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record){
        Optional<?> value = Optional.ofNullable(record.value());
        if (value.isPresent()){
            System.out.println(record);
            System.out.println("consumer fetch message successfully!! message : " + value.get());
        }
    }

}
