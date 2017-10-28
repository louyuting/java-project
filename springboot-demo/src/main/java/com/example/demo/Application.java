package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.example.demo")
// 设置Mybatis的Mapper扫描目标包
@MapperScan(basePackages = "com.example.demo.mapper", annotationClass = Mapper.class)
@EnableCaching
public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		Object Object = applicationContext.getBean("cacheManager");
        System.out.println(Object.toString());

    }
}
