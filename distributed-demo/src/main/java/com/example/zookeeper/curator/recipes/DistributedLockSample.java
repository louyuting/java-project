package com.example.zookeeper.curator.recipes;

import com.example.utils.LogUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.CountDownLatch;

/**
 * 分布式锁的实现: 借助curator来实现 InterProcessLock；
 * 其实也就是 InterProcessLock.acquire() 函数和 InterProcessLock.release()函数。
 *
 * Created by louyuting on 2017/6/19.
 */
public class DistributedLockSample {

    static String path = "/distributed_lock/lock";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("123.206.13.151:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3,3000))
            .build();

    public static void main(String[] args) {
        client.start();
        final InterProcessMutex lock = new InterProcessMutex(client, path);
        final CountDownLatch down = new CountDownLatch(1);

        for (int i=0; i<40; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        down.await();
                        lock.acquire();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    LogUtil.log_debug(" 是生成的订单号！");
                    try {
                        lock.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        down.countDown();
    }

}
