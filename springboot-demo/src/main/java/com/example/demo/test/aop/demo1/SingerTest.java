package com.example.demo.test.aop.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by louyuting on 17/1/20.
 * 这里使用依赖注入的方式测试:依赖注入采用反射机制实例化的.
 *
 */
public class SingerTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aop/aop-test_demo1.xml");
        Singer singer = (Singer)applicationContext.getBean("jack");
        singer.singSong();
    }
}
