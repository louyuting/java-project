package com.example.java.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * JDK 线程池测试案例
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/11/27
 */
public class ThreadPoolExecutorTest {

    private static class RunTask implements Runnable{
        @Override
        public void run() {
            long cnt = 0L;
            for (long i=0L; i<100000000L; i++){
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(1000));
        for (int i=0; i<100; i++){
            executor.execute(new ThreadPoolExecutorTest.RunTask());
        }
        System.out.println("over");
        while (true){
            if (executor.getActiveCount() == 0){
                executor.shutdown();
                System.out.println("getActiveCount == 0");
            }
            if (executor.isShutdown()){
                System.out.println("isShutdown");
            }
            if (executor.isTerminated()){
                System.out.println("isTerminated");
                break;
            }
        }

    }
}
