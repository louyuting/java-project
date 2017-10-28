package com.example.demo.test.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/2
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
