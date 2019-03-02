package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ximu
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/8/12
 */
public class Question152 {

    public static int maxProduct(int[] nums) {
        //暴力解法--超时
        if (nums.length == 1){
            return nums[0];
        }

        int max = -1;
        List<Integer> result = new ArrayList<>();
        for ( int i=1; i<=nums.length; i++ ){
            //子序列的长度从1到n；
            for (int j=0; j<=nums.length-i; j++){
                int temp = 1;
                for (int k=0; k<i; k++){
                    temp *= nums[j+k];
                }
                if (temp > max){
                    max = temp;
                    result.clear();
                    for (int k=0; k<i; k++){
                        result.add(nums[j+k]);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{0,2}));
        StringBuilder sb = new StringBuilder();
        String str = "bsiaudbionda";
    }
}
