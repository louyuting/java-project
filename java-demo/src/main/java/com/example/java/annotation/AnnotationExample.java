package com.example.java.annotation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * description
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/8/2
 */
public class AnnotationExample {
    @Override
    @MethodInfo(author="louyuting", comment ="Main method", date = "Nov 17 2012", revision = 1)
    public String toString() {
        return "Overriden toString method";
    }

    @Deprecated
    @MethodInfo(comment = "deprecated method", date = "Nov 17 2012")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    @MethodInfo(author = "louyuting", comment = "Main method", date = "Nov 17 2012", revision = 10)
    public static void genericsTest() throws FileNotFoundException {
        List l = new ArrayList();
        l.add("abc");
        oldMethod();
    }
}
