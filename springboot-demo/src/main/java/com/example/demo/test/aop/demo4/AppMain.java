package com.example.demo.test.aop.demo4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * description 基于注解配置
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class AppMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigBean.class);
        Performance performance = (Performance)applicationContext.getBean("performance");
        String res = performance.perfance();
        System.out.println("main:" + res);
        System.out.println("=====================================================");
        String res2 = performance.perfance("louyuting");
        System.out.println("main:" + res2);
    }

}
