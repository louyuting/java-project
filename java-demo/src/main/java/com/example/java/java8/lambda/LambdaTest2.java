package com.example.java.java8.lambda;

import java.util.Arrays;

import org.junit.Test;

/**
 * description Lambda表达式与Functional接口
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/4
 */
public class LambdaTest2 {
    String separator = ",";

    @Test
    public void test1(){
        Arrays.asList( "a", "b", "c", "d" ).forEach(e -> System.out.println( e + separator ) );
    }





}
