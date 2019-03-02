package com.example.jianzhioffer;

import java.util.Stack;

/**
 * Created by louyuting on 2017/2/20.
 * 面试题7-- 用两个栈实现队列（不考虑并发和容量问题）
 */
public class Question7 {
    private static Stack<Integer> stack1 = new Stack<Integer>();//入队
    private static Stack<Integer> stack2 = new Stack<Integer>();//出队

    //入队
    public static void push(int node) {
        stack1.push(node);
    }
    //出队
    public static Integer pop() {
        if (!stack2.isEmpty()){
            // 如果栈2非空，直接出栈
            return stack2.pop();
        }
        if (stack1.isEmpty()){
            // 队列已空
            throw new IllegalArgumentException("队列为空");
        }
        //将栈1内容推到栈2
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            Question7.push(i);
        }
        for(int i=0; i<10; i++){
            System.out.println(Question7.pop());
        }
    }
}
