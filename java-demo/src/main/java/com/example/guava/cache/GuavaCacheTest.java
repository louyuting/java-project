package com.example.guava.cache;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalListeners;
import com.google.common.cache.RemovalNotification;
import org.junit.Test;

/**
 * description guava的 Cache 的 test
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/5
 */
public class GuavaCacheTest {

    // 默认的加载缓存的策略 get-if-absent-compute
    @Test
    public void test_cache() throws ExecutionException {
        LoadingCache<String, String> caches = CacheBuilder.newBuilder()
            .concurrencyLevel(Runtime.getRuntime().availableProcessors())
            .expireAfterAccess(10, TimeUnit.MINUTES)// 10分钟该key没有被读写访问，就清楚
            .maximumSize(1000) //设置最大容量
            .expireAfterWrite(10, TimeUnit.MINUTES) //写了的10分钟后过期
            .removalListener((RemovalNotification<String, String> notification) -> {// 添加了移除监听器。
                System.out.println("移除了数据："+notification.getKey()+"--"+notification.getValue()+"--"+notification.getCause());
            })
            .build(new CacheLoader<String,String>(){
                @Override
                public String load(String key) throws Exception {
                    return getFromDatabase(key);
                }
                // 模拟从数据库查询
                private String getFromDatabase(String key){
                    Random random = new Random();
                    System.out.println("数据库查询");
                    return "value of "+ key +" from database-" + random.nextInt(1000);
                }
            });

        for (Integer i=0; i<100; i++){
            System.out.println(caches.get(i.toString()));
        }
        System.out.println("=================================");
        for (Integer i=0; i<105; i++){
            System.out.println(caches.get(i.toString()));
        }

        caches.invalidate("1");
        caches.invalidate("44");
    }


    // 使用 CallAble接口来实现get-if-absent-compute 机制
    @Test
    public void test_cache_callable() throws ExecutionException {
        // not LoadingCache
        Cache<String, String> caches = CacheBuilder.newBuilder()
            .maximumSize(1000) //设置最大容量
            .build();
        for (Integer i=0; i<100; i++){
            caches.get(i.toString(), new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        Random random = new Random();
                        return "value of database-" + random.nextInt(1000);
                    }
                });
        }
        // end
    }


    // 缓存回收：基于容量回收、定时回收和基于引用回收。
    /**
     * 1）设置缓存项的数目不超过固定值只需使用CacheBuilder.maximumSize(long)。
     *
     * 2）不同的缓存项有不同的“权重”（weights）——例如，如果你的缓存值，占据完全不同的内存空间，
     *    你可以使用CacheBuilder.weigher(Weigher)指定一个权重函数，并且用CacheBuilder.maximumWeight(long)指定最大总重。
     *
     * 3）定时回收：expireAfterAccess(long, TimeUnit)： 和 expireAfterWrite(long, TimeUnit)：
     *
     *
     */

    // 移除监听器, 同步
    @Test
    public void test_cache_removeListener() throws ExecutionException {
        LoadingCache<String, String> caches = CacheBuilder.newBuilder()
            .maximumSize(1000) //设置最大容量
            .expireAfterWrite(10, TimeUnit.MINUTES) //写了的10分钟后过期
            .removalListener(new RemovalListener<String,String>() {// 添加了移除监听器。
                @Override
                public void onRemoval(RemovalNotification<String, String> notification) {
                    String key = notification.getKey();
                    String value = notification.getValue();
                    RemovalCause cause = notification.getCause();
                    System.out.println("同步移除监听器：");
                    System.out.println("key:" + key +"\nvalue："+value + "\ncause:" + cause);
                }
            })
            .build(new CacheLoader<String,String>(){
                @Override
                public String load(String key) throws Exception {
                    return getFromDatabase(key);
                }
                private String getFromDatabase(String key){
                    Random random = new Random();
                    return "value of database-" + random.nextInt(1000);
                }
            });

        // 迭代：
        for (Integer i=0; i<10; i++){
            System.out.println(caches.get(i.toString()));
        }
        caches.put("key", "value");
        caches.invalidate("key");
        caches.invalidate("key");
    }

    // 移除监听器, 异步
    @Test
    public void test_cache_removeListener_asyn() throws ExecutionException {
        LoadingCache<String, String> caches = CacheBuilder.newBuilder()
            .maximumSize(1000) //设置最大容量
            .expireAfterWrite(10, TimeUnit.MINUTES) //写了的10分钟后过期
            .removalListener(RemovalListeners.asynchronous( (notification) -> {
                    String key = (String)notification.getKey();
                    String value = (String) notification.getValue();
                    RemovalCause cause = (RemovalCause)notification.getCause();
                    System.out.println("异步移除监听器：");
                    System.out.println("key:" + key +"\nvalue："+value + "\ncause:" + cause.name());
            }, Executors.newFixedThreadPool(1)))
            .build(new CacheLoader<String,String>(){
                @Override
                public String load(String key) throws Exception {
                    return getFromDatabase(key);
                }
                private String getFromDatabase(String key){
                    Random random = new Random();
                    return "value of database-" + random.nextInt(1000);
                }
            });
        // 迭代：
        for (Integer i=0; i<10; i++){
            System.out.println(caches.get(i.toString()));
        }
        caches.put("key", "value");
        caches.invalidate("key");
        caches.invalidate("key");
    }
}
