package com.example.zookeeper.curator;

import com.example.utils.LogUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 创建结点-异步回调获取结果
 * Created by louyuting on 2017/6/19.
 */
public class CreateNodeCallbackSample {

    static String path = "/zk-book/c3";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("123.206.13.151:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3,3000))
            .build();

    static CountDownLatch semaphore = new CountDownLatch(2);
    static ExecutorService service = Executors.newFixedThreadPool(2);// 线程池

    public static void main(String[] args) throws Exception {
        client.start();
        LogUtil.log_debug("Main Thread:" + Thread.currentThread().getName());

        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                        LogUtil.log_debug("event[code: " + event.getResultCode() + ", type: " + event.getType() + "]");

                        LogUtil.log_debug("Thread of processResult:  " + Thread.currentThread().getName());
                        semaphore.countDown();// 等待第二个回调
                    }
                }, service).forPath(path, "init-1".getBytes());

        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                        LogUtil.log_debug("event[code: " + event.getResultCode() + ", type: " + event.getType() + "]");

                        LogUtil.log_debug("Thread of processResult:  " + Thread.currentThread().getName());
                        semaphore.countDown();// 等待第二个回调
                    }
                }).forPath(path, "init2".getBytes());

        semaphore.await();
        service.shutdown();

        TimeUnit.SECONDS.sleep(10);
        System.out.println("延时10秒结束");
    }

}
