package com.example.demo.test.aop.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by louyuting on 17/1/20.
 */
public class ChiefTest {

    public static void main(String[] args) {
         ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:aop/aop_test_demo3.xml");
         Chief jack = (Chief)applicationContext.getBean("jack");
         Cake cake = (Cake)applicationContext.getBean("cake");
         cake.setName("blueberryCheeseCake");

         // 调用的业务方法，这Chief类应该被定义成一个切面， 切点就是makeOneCake()这个方法
         jack.makeOneCake(cake);
    }
}
