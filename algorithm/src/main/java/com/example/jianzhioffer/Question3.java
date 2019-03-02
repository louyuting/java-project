package com.example.jianzhioffer;

/**
 * Created by louyuting on 2017/2/20.
 * 面试题3--二维数组中查找:
 *      在一个二维数组中,每一行都按照从左到右递增的顺序排序,每一列都按照从上到下递增顺序排序
 *      实现:输入一个二维数组和数target,判断数组中是否有该数
 *
 *      时间复杂度是O(n)
 */
public class Question3 {

    public static boolean func(int[][] array, int target){

        if(null == array || array.length==0){
            return false;
        }

        //获取行和列
        int row = array.length;
        int column = array[0].length;
        int i=0;
        int j=column-1;

        //1. 首先从[0][column-1]开始
        for (j = column - 1; j >= 0; j--) {
            //2. 如果检索的下标[i][j]超出了数组的范围,就直接返回false
            if(!(i < row && j>=0)){
                return false;
            }
            //3. 如果target的值小于第j列的第一个数据,就将列减一 并continue
            if (array[i][j] > target) {
                continue;
            } else if (array[i][j] == target) {
                return true;
            } else if (array[i][j] <  target) {
                //第j列的第一个数据小于target, 所以在nums[0][j]的左下部分.
                i++;
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        boolean flag = func(nums, 15);
        System.out.println(flag);
    }
}
