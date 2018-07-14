package com.example.java.java8.defaultmethod;

/**
 * description 默认方法就是接口可以有实现方法，而且不需要实现类去实现其方法。
 *              我们只需在方法名前面加个default关键字即可实现默认方法。
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 29/06/2017
 */
public interface DefaultMethodTest {
    // 默认方法
    default void print(){
        System.out.println("这是DefaultMethodTest接口里面print()方法的默认实现！");
    }

    // 接口声明静态方法，并且可以提供实现。
    static void staticMethod(){
        System.out.println("这是 DefaultMethodTest 接口里面的一个静态方法");
    }
}
