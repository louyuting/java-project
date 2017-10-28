package com.example.demo.test.aop.demo2;

import org.aspectj.lang.JoinPoint;

/**
 * Created by louyuting on 17/1/20.
 */
public class Log2 {
    public void before() {
        System.out.println("before login");
    }

    public void after(JoinPoint joinpoint) {
        Object[] objects = joinpoint.getArgs();
        for (int i = 0; i < objects.length; i++) {
            if(objects[i] instanceof User){
                User user = (User)objects[i] ;
                System.out.println("save login log:" + user.getName() + " login");
            } else if (objects[i] instanceof String){
                String operationId = (String) objects[i];
                System.out.println("save login log:" + operationId);
            } else {
                System.err.println("输入参数有错");
            }
        }
    }
}
