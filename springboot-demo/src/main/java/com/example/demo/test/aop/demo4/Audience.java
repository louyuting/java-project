package com.example.demo.test.aop.demo4;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * description 观众定于成一个切面, 并定义了多个通知， 并且定义了切点，也就是在Performance.perfance()方法执行时候会触发通知
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
@Aspect
public class Audience {

    @Pointcut("execution(* com.example.demo.test.aop.demo4.Performance.perfance(..)) && @annotation(com.example.demo.test.aop.demo4.annotations.Authority)")
    public void performance(){}

    /**
     * 表演之前, 也就是前置通知
     */
    @Before("execution(* com.example.demo.test.aop.demo4.Performance.perfance(..))")
    public void silenceCellPhones(){
        System.out.println("将手机静音");
    }

    /**
     * 表演之前, 也就是前置通知
     * 这里切点引用上面定义的
     */
    @Before("performance()")
    public void takeSeats(){
        System.out.println("入座");
    }

    /**
     * 表演之后，欢呼，
     */
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("表演之后：欢呼");
    }

    /**
     * 表演失败之后：退款
     */
    @AfterThrowing("execution(* com.example.demo.test.aop.demo4.Performance.perfance(..))")
    public void demandRefund(){
        System.out.println("表演失败：退款");
    }

    /**
     * 整个表演的过程
     * @param joinPoint
     */
    /**
    @Around("performance()")
    public String watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("Around-将手机静音");
            System.out.println("Around-入座");
            // 表演
            Object r = joinPoint.proceed();// r是获取到的perfance()函数的执行返回值
            String res = (String)r;
            System.out.println("Around-return:" + res);
            System.out.println("Around-表演之后：欢呼");
            res = "修改了";
            return res;
        } catch (Throwable throwable) {
            System.out.println("Around-表演失败：退款");
            throwable.printStackTrace();
            return "exception";
        }
    }
    */
}
