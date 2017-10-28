package com.example.demo.test.aop.demo4;

import com.example.demo.test.aop.demo4.annotations.Authority;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class PerformanceImpl implements Performance {
    @Override
    public String perfance() {
        System.out.println("正确的执行了表演");
        return "default";
    }

    @Override
    @Authority
    public String perfance(String name) {
        System.out.println("正确的执行了表演" + name);
        return "default-@Authority";
    }
}
