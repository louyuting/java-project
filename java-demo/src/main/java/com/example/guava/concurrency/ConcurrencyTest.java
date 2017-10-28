package com.example.guava.concurrency;

import java.util.concurrent.Executors;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/6
 */
public class ConcurrencyTest {
    // ListenableFuture：完成后触发回调的Future
    @Test
    public void test_listenableFuture(){
        // service 是一个线程池,处理业务
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        // listeningExecutorServices线程池处理监听器
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(3));
        for(int i=0; i<1000; i++){
            ListenableFuture<String> explosion = service.submit(
                    () -> {System.out.println("["+Thread.currentThread().getName() +"]: print");
                    return Thread.currentThread().getName();}
                );
            // 添加runnable, 并且这个任务由listeningExecutorService 这个线程池执行
            explosion.addListener(()->{
                System.out.println("["+Thread.currentThread().getName()+"]:finished");
            }, listeningExecutorService);
            // 给业务线程添加回调函数， 判断执行结果。
            Futures.addCallback(explosion, new FutureCallback<Object>() {
                @Override
                public void onSuccess(Object result) {
                    System.out.println("["+Thread.currentThread().getName()+"]:success");
                }

                @Override
                public void onFailure(Throwable t) {
                    System.out.println(Thread.currentThread().getName()+"fail");
                }
            });
        }// end of foreach
    }// end of test
}
