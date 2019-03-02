package com.example.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

import com.example.leetcode.common.ListNode;

/**
 * Created by louyuting on 2017/2/20.
 * 面试题5-- 从尾到头打印链表: 输入一个链表的头结点, 从尾到头反过来打印链表;
 * key point: single list
 * solution: use auxiliary stack to temporary elements
 */
public class Question5 {
    /**
     * 1. 从头到尾遍历链表,然后每个数据入栈.
     * 2. 然后出栈,存入list
     * 时间O(n)
     * 空间O(n)
     * @return
     */
    public static ArrayList<Integer> func1(ListNode listNode){
        if(listNode == null){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer>  stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }


    // Solution 2
    private  static ArrayList<Integer> res = new ArrayList<>();
    /**
     * 利用递归
     * @return
     */
    public static ArrayList<Integer> func2(ListNode listNode){
        if(listNode != null){
            if(listNode.next!=null)
                func2(listNode.next);
            res.add(listNode.val);
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
