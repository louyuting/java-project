package com.example.demo.test.ioc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author ximu
 * @email chris.lyt@cainiao.com
 * @date 2017/9/15
 */
public class BeanLifeCycleTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:bean.xml");
        User user = applicationContext.getBean("louyuting-user", User.class);
        System.out.println(user);
        applicationContext.registerShutdownHook();
    }
}
