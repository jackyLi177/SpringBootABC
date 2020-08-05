package com.DesignPattern.single;

public class SingelInner {

    private SingelInner(){
        System.out.println("out...");
    }

    private static class SingelInnerClass{

        private SingelInnerClass(){
            System.out.println("in....");
        }

        private static final SingelInner instance = new SingelInner();
    }

    public static SingelInner getInstance(){
        return SingelInnerClass.instance;
    }

    public static void main(String[] args){
        System.out.println(SingelInner.getInstance());
        System.out.println(SingelInner.getInstance());
        System.out.println(SingelInner.getInstance());
    }
}
