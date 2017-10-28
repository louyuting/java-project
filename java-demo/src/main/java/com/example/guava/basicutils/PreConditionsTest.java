package com.example.guava.basicutils;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import org.junit.Test;
/**
 * description 前置条件
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/5
 */
public class PreConditionsTest {
    // check 參數條件
    @Test
    public void test1(){
        for(int i=1; i<10; i++){
            checkArgument(i > 0, "argument was %s but excpected 大于0", i);
        }
    }
    // check not null
    @Test
    public void test2(){
        String test = "tebhsjabd";
        checkNotNull(test, "变量%s是null", test);
    }
}
