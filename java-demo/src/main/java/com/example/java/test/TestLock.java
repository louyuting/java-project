package com.example.java.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 * @author ximu
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/7/18
 */
public class TestLock {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        lock.unlock();
        new Thread(()->{
            lock.lock();
        }).run();
        lock.unlock();

        Thread.sleep(100000);
    }


    @Test
    public void test1(){
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.err.println("xiexie");
    }
}
