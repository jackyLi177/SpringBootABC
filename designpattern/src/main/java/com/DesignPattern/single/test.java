package com.DesignPattern.single;

/**
 * @Author : liyongjie
 * @Date : 2018/9/4 0004
 */
public class test {

    public static void a(){
        int a = 0;
        for (int i = 0; i < 100000000; i++) {
            try {
                a = a + 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b(){
        int a = 0;
        try {
            for (int i=0;i < 100000000;i++){
                a = a + 1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
            long sTime = System.currentTimeMillis();
            a();
            long eTime = System.currentTimeMillis();
            System.out.println("用时"+ (eTime - sTime) +"ms");

//        long s = System.currentTimeMillis();
//        b();
//        long e = System.currentTimeMillis();
//        System.out.println("用时"+ (e - s) +"ms");

    }
}
