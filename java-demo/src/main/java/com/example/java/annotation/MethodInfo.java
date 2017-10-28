package com.example.java.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MethodInfo {
    String author() default "louyuting";
    String date() default "2017-8-02";
    int revision() default 1;
    String comment() default "";
}
