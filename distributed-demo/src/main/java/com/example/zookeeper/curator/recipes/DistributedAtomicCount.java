package com.example.zookeeper.curator.recipes;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.atomic.AtomicValue;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicInteger;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 分布式计数器
 * Created by louyuting on 2017/6/19.
 */
public class DistributedAtomicCount {

    static String path = "/distributed_atomic_count/lock";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("123.206.13.151:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3,3000))
            .build();

    public static void main(String[] args) throws Exception {
        client.start();

        DistributedAtomicInteger distributedAtomicInteger = new DistributedAtomicInteger(client, path, new RetryNTimes(3, 1000));

        final CountDownLatch down = new CountDownLatch(1);
        final CountDownLatch count = new CountDownLatch(40);

        for (int i=0; i<40; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        down.await();
                        distributedAtomicInteger.increment();
                        count.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        down.countDown();
        count.await();
        TimeUnit.SECONDS.sleep(2);
        AtomicValue<Integer> rc = distributedAtomicInteger.get();
        System.out.println("Result: " + rc.succeeded() + " value " + rc.postValue());
    }
}
