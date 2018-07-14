package com.example.java.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Description:
 * 1. 函数式接口(Functional Interface)就是一个具有一个方法的普通接口。
 * 2. 函数式接口可以被隐式转换为lambda表达式。
 * 3. 函数式接口可以现有的函数友好地支持 lambda。
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 29/06/2017
 */
public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("输出所有数据:");
        eval(list, n -> true);
        System.out.println("输出所有偶数:");
        eval(list, n -> n%2==0);
        System.out.println("输出大于 3 的所有数字:");
        eval(list, n -> n>3);
    }

    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {
            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}
