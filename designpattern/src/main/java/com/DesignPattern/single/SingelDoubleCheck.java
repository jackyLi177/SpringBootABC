package com.DesignPattern.single;

public class SingelDoubleCheck {

    private static SingelDoubleCheck instance;

    private SingelDoubleCheck(){}

    public static SingelDoubleCheck main(String[ ] args){
        if (instance == null){
            synchronized(SingelDoubleCheck.class){
                if (instance == null){
                    instance = new SingelDoubleCheck();
                }
            }
        }
        return instance;
    }
}
