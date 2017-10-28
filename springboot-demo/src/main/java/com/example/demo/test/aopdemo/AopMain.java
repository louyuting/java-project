package com.example.demo.test.aopdemo;

import com.example.demo.test.aopdemo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class AopMain {
    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXmlApplicationContext("classpath:proxy_aop_test.xml");
        UserService user = (UserService)application.getBean("userService");
        user.updateUser();
    }
}
