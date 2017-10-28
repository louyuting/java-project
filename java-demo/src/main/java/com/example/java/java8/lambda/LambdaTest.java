package com.example.java.java8.lambda;

import com.example.utils.LogUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * note: lambda表达式的测试代码:
 * 1. Lambda 表达式，也可称为闭包
 * 2. Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * 3. Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力。
 * 4. Lambda 表达式只能引用 final 或 final 局部变量，这就是说不能在 lambda 内部修改定义在域外的变量，否则会编译错误。
 * Created by louyuting on 29/06/2017.
 */
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest test = new LambdaTest();

        MathOperation add = (int a, int b) -> a+b;
        MathOperation sub = (a, b) -> a-b;
        MathOperation mul = (a, b) -> a*b;
        MathOperation div = (a, b) -> a/b;

        LogUtil.log(test.operate(10, 5, add));
        LogUtil.log(test.operate(10, 5, sub));
        LogUtil.log(test.operate(10, 5, mul));
        LogUtil.log(test.operate(10, 5, div));

        GreetingService service1 = message -> System.out.println("hello " + message);
        GreetingService service2 = (message) -> System.out.println("hello " + message);
        service1.sayMessage("service1");
        service2.sayMessage("service2");
    }

    interface MathOperation {
        Integer operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private Integer operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

    @Test
    public void test(){
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API",
                "Date and Time API");
        features.forEach(n -> System.out.println(n));

    }

}













