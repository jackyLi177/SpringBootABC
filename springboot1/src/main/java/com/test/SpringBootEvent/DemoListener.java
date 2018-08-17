package com.test.SpringBootEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author : liyongjie
 * @Date : 2018/8/2 0002
 */
@Component
public class DemoListener  implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("监听到了DemoEvent的事件！!"+msg);
    }
}
