package com.example.demo.test.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/2
 */
@Service
public class ScheduledService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000) //①
    public void reportCurrentTime() {
       System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 33 17 ? * *"  ) //②
    public void fixTimeExecution(){
      System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
    }
}
