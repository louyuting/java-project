package com.example.demo.test.ioc;

import java.beans.PropertyDescriptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

/**
 * @author ximu
 * @email chris.lyt@cainiao.com
 * @date 2017/9/15
 */
@Slf4j
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor() {
        System.out.println("MyInstantiationAwareBeanPostProcessor构造器");
    }

    // 实例化Bean之前调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("bean实例化之前调用，InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation");
        return null;
    }
    // 实例化Bean之后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("bean实例化之后前调用，InstantiationAwareBeanPostProcessor#postProcessAfterInstantiation");
        return false;
    }

    // 接口方法、设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean,
                                                    String beanName) throws BeansException {
        System.out.println("接口方法、设置某个属性时调用，InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法 ");
        return pvs;
    }
}
