package com.example.algorithm4.string;

import edu.princeton.cs.algs4.Insertion;

/**
 * 非等长的高位优先的字符串排序算法。
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/9
 */
public class MSD {

    private static final int R = 256; //字符基数
    private static final int M =15; //小数组的切换阈值
    private static String[] aux;//数据分类的辅助数组

    /**
     * 字符串末尾的约定处理方法。
     *
     * @param s 源字符串
     * @param d 检索字符串的第d位
     * @return
     */
    private static int charAt(String s, int d){
        if(d < s.length()){
            // 检索还不到字符串的末尾，正常返回
            return s.charAt(d);
        } else {
            // 检索到了字符串的末尾，返回-1，表示到了字符换的末尾
            return -1;
        }
    }

    /**
     * 排序
     * @param a 待排序的字符串数组
     */
    private static void sort(String[] a){
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N-1, 0);
    }

    /**
     * 递归进行字符串排序：以第d个字符作为键将a[lo]至a[hi]排序
     * @param a  待排序的字符串数组
     * @param lo 排序的起始下标
     * @param hi 排序的结束下标
     * @param d  键索引计数法的键在字符串中的下标
     */
    private static void sort(String[] a, int lo, int hi, int d){
        // 以第d个字符作为键将a[lo]至a[hi]排序
        if(hi <= lo+M){
            // 当排序的数据量范围很小的时候，直接用暴露排序。
            Insertion.sort(a, lo, hi);
            return;
        }
        int[] count = new int[R+2];//计算频率， 体会这里R+2的精妙之处
        for(int i=lo; i<=hi; i++){
            count[charAt(a[i], d)+2]++;
        }
        //将频率转换成索引
        for(int r=0; r<R+1; r++){
            count[r+1] += count[r];
        }
        // 数据分类
        for(int i=lo; i<=hi; i++){
            aux[count[charAt(a[i], d)]+1] = a[i];
        }
        // 回写
        for(int i=lo; i<=hi; i++){
            a[i] = aux[i-lo];
        }
        // 递归的以每个字符串为键进行排序
        for(int r=0; r<R; r++){
            sort(a, lo+count[r], lo+count[r+1]-1, d+1);
        }
    }
}
