package com.example.zookeeper.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * 使用curator 来创建session 的demo--同步
 * Created by louyuting on 2017/6/19.
 */
public class CreateSessionSample {

    public static void main(String[] args) throws InterruptedException {
        //定义连接重试策略：通过一定的计算公司，随着重试次数的增加，sleep的时间会越来越大。
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.newClient("123.206.13.151:2181", 5000, 3000, retryPolicy);
        client.start();

        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
