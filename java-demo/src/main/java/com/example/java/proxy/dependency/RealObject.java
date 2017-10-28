package com.example.java.proxy.dependency;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/28
 */
public class RealObject implements Interface {
    public void doSomething() {
        System.out.println("doSomething");
    }

    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}
