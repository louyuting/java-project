package com.example.java.proxy.dependency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/28
 */
public class DynamicProxyHandler implements InvocationHandler {
    // 被代理的对象
    private Object proxied;
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() + ", method: " + method + ", args: " + args);
        if(args != null)
            for(Object arg : args)
                System.out.println("  " + arg);

        return method.invoke(proxied, args);
    }
}