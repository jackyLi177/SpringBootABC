package com.test;


import java.util.regex.Pattern;

/**
 * @Author : liyongjie
 * @Date : 2018/7/13 0013
 */
public class Demo {

    public static void main(String[] args){

        String s = "11,31,104,203,204,304,403,404;";
        System.out.println(s.matches("[0-8,;]+"));
    }

}
