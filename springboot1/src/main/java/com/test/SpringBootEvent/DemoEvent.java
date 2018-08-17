package com.test.SpringBootEvent;

import org.springframework.context.ApplicationEvent;

/**
 * @Author : liyongjie
 * @Date : 2018/8/2 0002
 */
public class DemoEvent extends ApplicationEvent {

    private String msg;

    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
