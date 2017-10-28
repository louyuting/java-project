package com.example.java.reflect.dependency;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/28
 */
public class First {
    private static int staticA = 1;
    private int B=20;

    public First() {
        System.out.println("First类的构造函数");
    }

    static {
        System.out.println("staticA="+staticA);
        staticA=2;
        System.out.println("静态域的Loading First");

    }

    // 先执行这段代码段然后再执行构造器
    {
        System.out.println("staticA="+staticA);
        System.out.println("B=" + B);
        System.out.println("非静态域参数初始化");
    }
}
