package com.example.demo.test.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/2
 */
@Configuration
@ComponentScan("com.example.demo.test.schedule")
@EnableScheduling
public class TaskSchedulerConfig {
}
