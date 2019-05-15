package com.jacky.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：lyj
 * @date ：2019/5/15 10:40
 */
@RestController
public class TestController {

    @Autowired
    private MyKafkaProducer kafkaProducer;

    @GetMapping("/send")
    public void testSend(){
        kafkaProducer.send("****** kafka test message ******");
    }

}
