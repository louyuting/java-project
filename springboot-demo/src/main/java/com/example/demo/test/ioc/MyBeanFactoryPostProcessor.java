package com.example.demo.test.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 这个类在bean开始实例化之前被调用，所以可以修改bean的属性，修改每个bean里面的properties
 *
 * <li>作用范围是所有的bean</li>
 *
 * @author ximu
 * @email chris.lyt@cainiao.com
 * @date 2017/9/15
 */
@Slf4j
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
    public MyBeanFactoryPostProcessor() {
        System.out.println("MyBeanFactoryPostProcessor 构造器实例化");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("MyBeanFactoryPostProcessor#postProcessBeanFactory()");

        System.out.println("count bean = "+beanFactory.getBeanDefinitionCount());

        System.out.println("beanDefinitionName number is "+ beanFactory.getBeanDefinitionNames().length);
        for(String beanDefinitionName : beanFactory.getBeanDefinitionNames()){
            System.out.println("   "+ beanDefinitionName);
        }

        System.out.println("singletonNames number is "+ beanFactory.getSingletonNames().length);
        for(String singletonName : beanFactory.getSingletonNames()){
            System.out.println("   "+ singletonName);
        }

        BeanDefinition bd = beanFactory.getBeanDefinition("louyuting-user");
        bd.getPropertyValues().addPropertyValue("id", "110");
    }
}
