package com.test;

/**
 * 只有一个接口函数需要被实现的接口类型，我们叫它”函数式接口“
 *
 * 加上一个声明@FunctionalInterface, 这样别人就无法在里面添加新的接口函数
 *
 * @Author : liyongjie
 * @Date : 2018/6/1 0001
 */
@FunctionalInterface
public interface MyLambdaInterface {

    String dos(String s);

}
