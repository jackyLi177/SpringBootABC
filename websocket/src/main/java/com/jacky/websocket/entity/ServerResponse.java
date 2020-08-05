package com.jacky.websocket.entity;

/**
 * 服务器向浏览器返回的信息
 *
 * @Author : liyongjie
 * @Date : 2018/9/21 0021
 */
public class ServerResponse {

    private String responseMsg;

    public ServerResponse(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }
}
