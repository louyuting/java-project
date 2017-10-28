package com.example.demo.test.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * bean
 * @author ximu
 * @description
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/8/30
 */
@Slf4j
public class User implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String id;
    private String name;

    private BeanFactory beanFactory;
    private String beanName;

    public User() {
        System.out.println("User 构造器实例化");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        System.out.println("注入属性 id");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("注入属性 name");
        this.name = name;
    }

    // BeanFactoryAware
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】 接口调用 BeanFactoryAware.setBeanFactory(BeanFactory beanFactory)");
        this.beanFactory = beanFactory;
    }

    // BeanNameAware
    @Override
    public void setBeanName(String name) {
        System.out.println("【BeanNameAware接口】 接口调用 BeanNameAware.setBeanName(String name)");
        this.beanName = name;
    }

    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method 属性指定的初始化方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }
}
