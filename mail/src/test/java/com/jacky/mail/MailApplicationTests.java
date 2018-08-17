package com.jacky.mail;

import com.jacky.mail.service.MyMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

    @Autowired
    private MyMailService myMailService;

    @Test
    public void contextLoads() {
        myMailService.sendSimpleMail("1192964153@qq.com","test simple mail"," hello this is simple mail");
    }

}
