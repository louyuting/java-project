package com.example.java.delayqueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/11/13
 */
public class DelayQueueTest {
    private static DelayQueue<Elem> queue = new DelayQueue<Elem>();

    public static void main(String[] args) throws InterruptedException {
        queue.offer(new Elem<>(12, 12000000000l));//12s
        queue.offer(new Elem<>(11, 11000000000l));//11s
        queue.offer(new Elem<>(10, 10000000000l));//10s
        queue.offer(new Elem<>(1, 70000000l));//70ms
        queue.offer(new Elem<>(2, 60000000l));
        queue.offer(new Elem<>(3, 50000000l));
        queue.offer(new Elem<>(4, 40000000l));
        queue.offer(new Elem<>(5, 30000000l));
        queue.offer(new Elem<>(6, 20000000l));
        queue.offer(new Elem<>(7, 10000000l));//10ms
        /**
         * 7 这个对象，存活时间最小，所以在优先队列中处于队列头部。
         * 只要超过了其存活时间，就可以被poll
         */
        TimeUnit.SECONDS.sleep(1);
        System.out.println("begin");
        while (!queue.isEmpty()){
            System.out.println(queue.take().getT());
        }
    }

    public static class Elem<T> implements Delayed{
        /**
         * delay对象
         */
        private T t;
        /**
         * 存活时间，优先级队列里面按照存活时间的大小来排序，存活时间最小的在队列最上面。
         */
        private long liveTime ;
        /**
         * 移除时间点，纳秒级别
         */
        private long removeTime;

        public Elem(T t,long liveTime){
            this.setT(t);
            this.liveTime = liveTime;
            this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, TimeUnit.NANOSECONDS) + System.nanoTime();
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == null) return 1;
            if (o == this) return 0;
            if (o instanceof DelayedItem){
                Elem<T> tmpDelayedItem = (Elem<T>)o;
                if (liveTime > tmpDelayedItem.liveTime ) {
                    return 1;
                }else if (liveTime == tmpDelayedItem.liveTime) {
                    return 0;
                }else {
                    return -1;
                }
            }
            long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
            return diff > 0 ? 1:diff == 0? 0:-1;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(removeTime - System.nanoTime(), unit);
        }

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
        @Override
        public int hashCode(){
            return t.hashCode();
        }

        @Override
        public boolean equals(Object object){
            if (object instanceof DelayedItem) {
                return object.hashCode() == hashCode() ?true:false;
            }
            return false;
        }
    }
}
