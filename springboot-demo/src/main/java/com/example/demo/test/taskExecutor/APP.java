package com.example.demo.test.taskExecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/2
 */
public class APP {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncExecutorTaskService asyncTaskService = context.getBean(AsyncExecutorTaskService.class);
        for(int i =1 ;i<=20; i++){
            asyncTaskService.executeAsyncTask1(i);
            asyncTaskService.executeAsyncTask2(i);
        }
        context.close();
    }
}
