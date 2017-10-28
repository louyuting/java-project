package com.example.demo.test.taskExecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/2
 */
@Service
public class AsyncExecutorTaskService {

    @Async
    public void executeAsyncTask1(Integer i){
        System.out.println("task1: 执行异步任务: "+i);
    }

    @Async
    public void executeAsyncTask2(Integer i){
        System.out.println("task2: 执行异步任务: "+ i);
    }
}
