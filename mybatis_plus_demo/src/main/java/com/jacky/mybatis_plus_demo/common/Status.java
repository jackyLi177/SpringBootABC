package com.jacky.mybatis_plus_demo.common;

public enum Status {

    REQUEST_SUCCESS(200,"success"),
    REQUEST_FAIL(500,"failed");

    private int code;
    private String message;
    private Status(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
