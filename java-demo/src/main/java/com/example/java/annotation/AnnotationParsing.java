package com.example.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class AnnotationParsing {

    public static void main(String[] args) {
        try {
            for(Method method : AnnotationParsing.class.getClassLoader().
                loadClass("com.example.java.annotation.AnnotationExample").
                getMethods()){

                if(method.isAnnotationPresent(MethodInfo.class)){
                    System.out.println("迭代当前method的所有的annotation");
                    for(Annotation annotation : method.getDeclaredAnnotations()){
                        //迭代当前方法的全部注解
                        System.out.println("annotation in method [" + method.toString() +"]:" + annotation);
                        MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                        if(methodInfo.revision() == 1){
                            System.out.println("Method with revision no 1 = "+ method);
                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
