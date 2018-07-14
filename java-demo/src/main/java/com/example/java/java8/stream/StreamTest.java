package com.example.java.java8.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * description 流的测试代码，简介如下：
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象。
 * 这种风格将要处理的元素集合看作一种流， 流在管道中传输， 并且可以在管道的节点上进行处理， 比如筛选， 排序，聚合等。
 * 元素流在管道中经过中间操作（intermediate operation）的处理，最后由最终操作(terminal operation)得到前面处理的结果。
 * +--------------------+       +------+   +------+   +---+   +-------+
 * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 * +--------------------+       +------+   +------+   +---+   +-------+
 *
 * Stream（流）是一个来自数据源的元素队列并支持聚合操作
 *  1）元素是特定类型的对象，形成一个队列。 Java中的Stream并不会存储元素，而是按需计算。
 *  2）数据源 流的来源。 可以是集合，数组，I/O channel， 产生器generator 等。
 *  3）聚合操作 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
 * 和以前的Collection操作不同， Stream操作还有两个基础的特征：
 *  1）Pipelining: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道， 如同流式风格（fluent style）。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。
 *  2）内部迭代： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。
 *
 * 在 Java 8 中, 集合接口有两个方法来生成流：
 *  1）stream() − 为集合创建串行流。
 *  2）parallelStream() − 为集合创建并行流。
 *
 *
 * author ximu
 * email chris.lyt@alibaba-inc.com
 * date 30/06/2017
 */
public class StreamTest {

    public static void main(String[] args) {

    }


    //stream
    @Test
    public void test1(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> res = strings.stream()
                                  .filter(a -> a != null && !a.isEmpty())
                                  .collect(Collectors.toList());
        System.out.println(res);

        List<String> filtered = strings.stream()
                                       .filter(string -> !string.isEmpty())
                                       .collect(Collectors.toList());
        System.out.println(filtered);
    }

    // foreach
    @Test
    public void test2(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    // map
    @Test
    public void test3(){
        List<Integer> nums = Arrays.asList(2,3,4,2,1,5,9,6,4);
        // 获取对应的平方数
        List<Integer> ss = nums.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(ss);
    }

    // filter
    @Test
    public void test4(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(str -> str.isEmpty()).count();
        System.out.println(count);
    }

    // limit
    @Test
    public void test5(){
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }

    // sorted
    @Test
    public void test6(){
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }

    // 并行（parallel）程序  parallelStream
    @Test
    public void test7(){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }

    // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
    @Test
    public void test8(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
    }

    // 统计
    @Test
    public void test9() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

}




















