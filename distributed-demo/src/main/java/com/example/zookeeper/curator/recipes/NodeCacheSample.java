package com.example.zookeeper.curator.recipes;

import com.example.utils.LogUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

/**
 * NodeCache监听指定Zookeeper数据：节点本身的变化
 * Created by louyuting on 2017/6/19.
 */
public class NodeCacheSample {
    static String path = "/zk-book/c6";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("123.206.13.151:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3,3000))
            .build();

    public static void main(String[] args) throws Exception {
        client.start();
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath(path, "init".getBytes());

        final NodeCache cache = new NodeCache(client, path, false);
        cache.start(true);
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                // System.out.println("cache:"+cache.getCurrentData());
                LogUtil.log_debug("node data update, new data: " +
                        cache.getCurrentData()==null? "null": cache.getCurrentData().getData().toString());
            }
        });
        client.setData().forPath(path, "u".getBytes());

        TimeUnit.SECONDS.sleep(1);

        client.delete().deletingChildrenIfNeeded().forPath(path);
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
