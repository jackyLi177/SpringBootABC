package com.jacky.jwtdemo.bean;

/**
 * 请求token时的返回体
 * @Author : liyongjie
 * @Date : 2018/8/21 0021
 */
public class TokenResp {

    //返回的信息
    private String info;
    private String token;
    //状态
    private boolean flag = true;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
