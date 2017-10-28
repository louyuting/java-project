package com.example.demo.test.aop.demo4;

/**
 * description 现场表演接口
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public interface Performance {
    /**
     * 当执行方法时要触发通知，所以需要一个切面
     */
    String perfance();


    String perfance(String name);
}
