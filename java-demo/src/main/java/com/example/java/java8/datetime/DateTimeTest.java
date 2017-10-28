package com.example.java.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * description Java8的date和time的类
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 2017/7/5
 */
public class DateTimeTest {

    @Test
    public void test1(){
        LocalDateTime timePoint = LocalDateTime.now();// current date and time
        System.out.println(timePoint.toLocalTime());
        System.out.println(timePoint);

        System.out.println(LocalDate.of(2012, Month.DECEMBER, 12));
        System.out.println(LocalDate.ofEpochDay(150));// from 1970

        System.out.println(LocalTime.of(17,18));
        System.out.println(LocalTime.parse("10:14:13"));
    }


    @Test
    public void test2(){
        LocalDateTime timePoint = LocalDateTime.now();// current date and time
        LocalDate theDate = timePoint.toLocalDate();
        Month month = timePoint.getMonth();
        int day = timePoint.getDayOfMonth();
        timePoint.getSecond();
    }

    @Test
    public void test3(){
        LocalDateTime timePoint = LocalDateTime.now();// current date and time
        LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);
    }

    @Test
    public void test4(){
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
    }
}
