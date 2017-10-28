package com.example.demo.test.aop.demo4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo.test.aop.demo4")
/** bean开启自动代理切面 */
@EnableAspectJAutoProxy
public class ConfigBean {

    /**
     * 注入切面这个bean
     * @return
     */
    @Bean
    public Audience audience(){
        return new Audience();
    }

    @Bean(value = "performance")
    public Performance performance(){
        return new PerformanceImpl();
    }


}
