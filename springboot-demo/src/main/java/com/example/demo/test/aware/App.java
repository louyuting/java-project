package com.example.demo.test.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/1
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }
}
