package com.example.java.reflect;

import com.example.java.reflect.dependency.Second;
import com.example.java.reflect.dependency.Third;
import org.junit.Test;

/**
 * Created by louyuting on 17/1/15.
 */
public class ClassTest2 {

    @Test
    public void test() {
        try {
            Class secondA = Class.forName("com.example.java.reflect.dependency.Second");
            secondA = Third.class;
            Class<Second> SecondB = (Class<Second>) Class.forName("com.example.java.reflect.dependency.Second");
            //SecondB = Third.class;//error
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        try {
            Class<?> secondA = Class.forName("com.example.java.reflect.dependency.Second");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
