package com.jacky.mybatis_plus_demo.common;

import javax.xml.ws.Response;

public class ResponseEntity<T> {

    private int code;
    private String message;
    private T data;

    public ResponseEntity(){
        this.code = Status.REQUEST_SUCCESS.getCode();
        this.message = Status.REQUEST_SUCCESS.getMessage();
    }

    public ResponseEntity(Status status){
        this.code = status.getCode();
        this.message  = status.getMessage();
    }

    public ResponseEntity(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
