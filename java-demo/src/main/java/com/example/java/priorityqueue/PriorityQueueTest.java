package com.example.java.priorityqueue;

import java.util.PriorityQueue;
import java.util.Queue;

import com.google.common.collect.Queues;

/**
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/11/13
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = Queues.newPriorityQueue();
        test2(queue);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    private static void test1(Queue queue){
        queue.add(1);
        queue.add(8);
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(448);
        queue.add(328);
        queue.add(18);
        queue.add(558);
        queue.add(38);
        queue.add(98);
    }

    private static void test2(Queue queue){
        queue.add("a");
        queue.add("v");
        queue.add("d");
        queue.add("s");
        queue.add("z");
        queue.add("da");
        queue.add("dda");
        queue.add("tgfa");
        queue.add("yha");
        queue.add("ihfa");
        queue.add("mdtad");
    }
}
