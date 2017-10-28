package com.example.java.proxy;

import java.lang.reflect.Proxy;

import com.example.java.proxy.dependency.DynamicProxyHandler;
import com.example.java.proxy.dependency.Interface;
import com.example.java.proxy.dependency.RealObject;



class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);

        System.out.println("====Insert a proxy and call again====");
        /**Insert a proxy and call again:*/
        Interface proxy = (Interface)Proxy.newProxyInstance(
            Interface.class.getClassLoader(),
            new Class[]{ Interface.class },
            new DynamicProxyHandler(real));
        //
        consumer(proxy);
    }
}

/* Output: (95% match)
doSomething
somethingElse bonobo
====Insert a proxy and call again====
**** proxy: class test.$Proxy0, method: public abstract void com.example.java.proxy.Interface.doSomething(), args: null
doSomething
**** proxy: class test.$Proxy0, method: public abstract void com.example.java.proxy.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@3fe329eb
  bonobo
somethingElse bonobo
*///:~
