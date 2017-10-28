package com.example.zookeeper.curator.recipes;

import com.example.utils.LogUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.concurrent.TimeUnit;

/**
 * Master 选举的demo:
 *
 * 实现思路：选择一个根节点，比如/master_select, 多台机器同时向该结点创建一个子结点 /master_select/lock，利用Zookeeper的特性，
 * 最终只能有一台机器能够创建成功，成功的那台机器就是 Master
 *
 * Created by louyuting on 2017/6/19.
 */
public class MasterSelectSample {
    static String path = "/master_select/lock";
    static CuratorFramework client = CuratorFrameworkFactory.builder()
            .connectString("123.206.13.151:2181")
            .sessionTimeoutMs(5000)
            .connectionTimeoutMs(3000)
            .retryPolicy(new ExponentialBackoffRetry(1000, 3,3000))
            .build();


    public static void main(String[] args) throws InterruptedException {
        client.start();

        LeaderSelector selector = new LeaderSelector(client, path, new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework client) throws Exception {
                LogUtil.log_debug("成为master角色");
                TimeUnit.SECONDS.sleep(5);
                LogUtil.log_debug("完成Master操作，释放Master权利");
            }
        });

        selector.autoRequeue();
        selector.start();
        TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    }
}
