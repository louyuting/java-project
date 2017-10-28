package com.example.demo.test.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ximu
 * @email chris.lyt@cainiao.com
 * @date 2017/9/15
 */
@Slf4j
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor 构造器实例化");
    }

    // 初始化之前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean初始化之前调用：BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return bean;
    }

    // 初始化之后调用
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("bean初始化之后调用：BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return bean;
    }
}
