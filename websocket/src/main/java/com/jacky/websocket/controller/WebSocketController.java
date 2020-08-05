package com.jacky.websocket.controller;

import com.jacky.websocket.entity.BrowserMessage;
import com.jacky.websocket.entity.ServerResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @Author : liyongjie
 * @Date : 2018/9/21 0021
 */
@Controller
public class WebSocketController {

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ServerResponse getResponse(BrowserMessage message) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ServerResponse("欢迎使用WebSocket  " + message.getMsg());
    }

}
