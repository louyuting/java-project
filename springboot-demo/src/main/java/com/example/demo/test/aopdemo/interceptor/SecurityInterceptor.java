package com.example.demo.test.aopdemo.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * description: 模拟切面1--拦截器
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class SecurityInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.err.println("执行安全检验！");
        Method method = methodInvocation.getMethod();
        System.err.println(method);
        return methodInvocation.proceed();
    }
}
