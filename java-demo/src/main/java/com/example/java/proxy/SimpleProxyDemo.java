package com.example.java.proxy;

import com.example.java.proxy.dependency.Interface;
import com.example.java.proxy.dependency.RealObject;
import com.example.java.proxy.dependency.SimpleProxy;

class SimpleProxyDemo {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }
    public static void main(String[] args) {
        consumer(new RealObject());

        System.out.println("=========================");

        consumer(new SimpleProxy(new RealObject()));
    }
} /* Output:
doSomething
somethingElse bonobo
=========================
SimpleProxy doSomething
doSomething
SimpleProxy somethingElse bonobo
somethingElse bonobo
*///:~
