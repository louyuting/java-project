package com.example.java.java8.lambda;

/**
 * lambda表达式测试demo
 * Created by louyuting on 2017/6/19.
 */
public class Hello {
    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = () -> System.out.println(toString());
    Runnable r3 = () -> System.out.println("hello world 3");

    public String toString() {  return "Hello, world"; }

    public static void main(String... args) {
        new Hello().r1.run();
        new Hello().r2.run();
        new Hello().r3.run();
    }
}