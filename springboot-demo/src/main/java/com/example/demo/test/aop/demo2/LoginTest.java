package com.example.demo.test.aop.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by louyuting on 17/1/20.
 * 利用AOP 记录日志
 */
public class LoginTest {
    public static void main(String[] args) {
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aop/aop_test_demo2.xml");
         LoginServiceImpl loginService = applicationContext.getBean(LoginServiceImpl.class);
         User user = applicationContext.getBean(User.class);
         loginService.login(user, "0001");
    }
}
