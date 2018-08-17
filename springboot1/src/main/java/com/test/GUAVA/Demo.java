package com.test.GUAVA;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.jupiter.api.Test;


/**
 * @Author : liyongjie
 * @Date : 2018/6/12 0012
 */
public class Demo {

    @Test
    public void test(){
        System.out.println(Objects.hashCode("1",1,"jjjj"));
        Multiset multiset = HashMultiset.create();
//        Optional<Integer> a = Optional.fromNullable(null);
//        Optional<Integer> b = Optional.fromNullable(10);
//        System.out.println(sum(a,b));
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split("the ,quick, , brown         , fox,              jumps, over, the, lazy, little dog."));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {

        System.out.println("first paramter is present :" + a.isPresent());
        System.out.println("second paramter is present :" + b.isPresent());

        a = a.or(Optional.fromNullable(5));
        b = b.or(Optional.fromNullable(5));
        System.out.println("first parameter is :"+a.get()+"-->"+a);
        System.out.println("second parameter is :"+b.get()+"-->"+b);

        return a.get()+b.get();
    }

}

