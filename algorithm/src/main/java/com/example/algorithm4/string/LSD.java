package com.example.algorithm4.string;

/**
 * 低位优先的等长字符串排序
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/9
 */
public class LSD {

    /**
     * 低位优先排序算法
     *
     * @param a 字符串数组
     * @param w 字符串的长度
     */
    public static void sort(String[] a, int w){
        int N = a.length;
        int R = 256;// 字符的ASCII码的范围，数字0~9的ASCII范围是48~57/ 字符A~Z是65~90/ 字符a~z是97~122
        String[] aux = new String[N];

        for(int d=w-1; d>=0; d--) {
            // 根据第d个字符用键索引计数法排序
            int[] count = new int[R+1];// 统计每个字符对应的ASCII出现的次数，count[0]什么都不保存，默认是0
            //统计出现的频率
            for (int i=0; i<N; i++){
                count[a[i].charAt(d)+1] ++;
            }
            // 将频率转换成索引
            for (int r=0; r<R; r++){
                count[r+1] += count[r];// count[r]保存的是比ASCII为r的字符小的字符出现的次数
            }
            // 将元素分类
            for (int i=0; i<N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            // 回写
            for(int i=0; i<N; i++){
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        int a = 'a';
        System.out.println(a);
    }
}
