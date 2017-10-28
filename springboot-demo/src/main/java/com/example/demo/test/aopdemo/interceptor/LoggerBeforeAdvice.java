package com.example.demo.test.aopdemo.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * description：模拟切面-2
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class LoggerBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.err.println("保存更新日志！");
    }
}
