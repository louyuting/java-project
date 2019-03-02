package com.example.java.pdd;

public class Main {
    public static void main(String[] args) {
        String str = "130 140 150 160";
        String[] strs = str.split(" ");
        // 保存输入的数据
        int[] elems = new int[strs.length];
        int tail = strs.length-1;
        for (int i = 0; i < strs.length; i++) {
            elems[i] = Integer.valueOf(strs[i]);
        }
        /**
         * 从最后一个和第一个货物为索引，
         * 1）如果elems[tail] + elems[start] >300,则最后一个货物单独装一辆车
         * 2）elems[tail] + elems[start]<=300 最轻和最重的单独打包
         */
        int count =0;
        int start = 0;
        while(start <= tail){
            if(elems[tail] + elems[start] > 300){
                count++;
                tail--;
                continue;
            }
            start++;
            tail--;
            count++;
        }
        System.out.println(count);
    }
}