package com.example.java.reflect;

import com.example.java.reflect.dependency.First;
import org.junit.Test;

/**
 * Created by louyuting on 17/1/14.
 * reflect测试用例
 */
public class ClassTest {
    //通过一个实例对象获取完整的包名和类名
    @Test
    public void test1() throws ClassNotFoundException {
        Class first1 = First.class;//没有加载类
        System.out.println("first1:" + first1);
    }

    //实例化class类对象
    @Test
    public void test2() throws ClassNotFoundException {
        Class first2 = Class.forName("com.example.java.reflect.dependency.First");//加载类到JVM
        System.out.println("first2:" + first2);
        try {
            first2.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    // 加载类到JVM内存并把非静态域参数初始化.
    @Test
    public void test3() throws ClassNotFoundException {
        Class<?> first3 = new First().getClass();//
        System.out.println("first3:" + first3);
    }
}











