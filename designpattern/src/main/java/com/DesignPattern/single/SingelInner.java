package com.DesignPattern.single;

public class SingelInner {

    private SingelInner(){}

    private static class SingelInnerClass{
        private static final SingelInner instance = new SingelInner();
    }

    public static SingelInner getInstance(){
        return SingelInnerClass.instance;
    }
}
