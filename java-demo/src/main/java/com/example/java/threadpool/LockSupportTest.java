package com.example.java.threadpool;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ximu
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/8/7
 */
public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
            ()->{
                System.out.println("周末要打游戏！");
                LockSupport.park();
                System.out.println("陪女朋友逛街逛街！");
            }
        );
        thread.start();
        LockSupport.unpark(thread);
        Thread.sleep(5000);
        System.out.println("女朋友叫着男票逛街逛街逛街！");
    }
}
