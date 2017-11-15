package com.example.java.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 一个ForkJoinTest对应的一个task, 也就是一个计算单元
 * 一个task可以拆分成n个小的 forkjoin task， 也就是forkjoin task数组
 *
 *
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/11/14
 */
public class ForkJoinTest extends RecursiveTask<Long>{

    private static final long MAX = 100000;
    private long start;
    private long end;

    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        if( (end-start) < MAX ){
            for (long i= start; i<=end; i++){
                sum += i;
            }
        }else {
            long middle = (start+end)/2;
            ForkJoinTest left = new ForkJoinTest(start, middle);
            ForkJoinTest right = new ForkJoinTest(middle+1, end);
            left.fork();
            right.fork();
            long leftRes = left.join();
            long rightRes = right.join();
            sum = leftRes+rightRes;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start1 = System.nanoTime();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest test = new ForkJoinTest(1, Integer.MAX_VALUE);
        Future result = pool.submit(test);
        long end1 = System.nanoTime();
        System.out.println(result.get());
        System.out.println(String.format("time1=%s", end1-start1));

        long start2 = System.nanoTime();
        long sum = 0l;
        for (long i=1; i<=Integer.MAX_VALUE; i++){
            sum+=i;
        }
        long end2 = System.nanoTime();
        System.out.println(sum);
        System.out.println(String.format("time2=%s", end2-start2));
    }
}
