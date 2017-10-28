package com.example.zookeeper.curator.recipes;

import com.example.utils.LogUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

/**
 * 监听指定Zookeeper数据节点的：子结点变化情况
 * Created by louyuting on 2017/6/19.
 */
public class PathChildrenCacheSample {

    static String path = "/zk-book";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("123.206.13.151:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3,3000))
            .build();


    public static void main(String[] args) throws Exception {
        client.start();

        PathChildrenCache cache = new PathChildrenCache(client, path, true);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                switch (event.getType()){

                    case CHILD_ADDED:
                        LogUtil.log_debug("CHILD_ADDED, " + event.getData().getPath());
                        break;

                    case CHILD_UPDATED:
                        LogUtil.log_debug("CHILD_UPDATED:" + event.getData().getPath());
                        break;

                    case CHILD_REMOVED:
                        LogUtil.log_debug("CHILD_REMOVED:" + event.getData().getPath());
                        break;

                    default:
                        break;
                }
            }
        });
        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath(path, "init".getBytes());

        client.create().creatingParentsIfNeeded()
                .withMode(CreateMode.PERSISTENT)
                .forPath(path+"/c8", "c8".getBytes());

        TimeUnit.SECONDS.sleep(1);
        client.delete().forPath(path+"/c8");
        TimeUnit.SECONDS.sleep(1);
        client.delete().forPath(path);

        TimeUnit.SECONDS.sleep(10000);

    }

}
