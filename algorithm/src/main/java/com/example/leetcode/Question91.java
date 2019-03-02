package com.example.leetcode;

/**
 * @author ximu
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/8/12
 */
public class Question91 {


    private int func(String s){
        if(s.length()==1){
            return 1;
        }else if(s.length()==2){
            return func(String.valueOf(s.charAt(0))) +
                func(String.valueOf(s.charAt(1))) +
                (((Integer.valueOf(s)>=1) && (Integer.valueOf(s)<=26))? 1 : 0);
        }
        return func(s.substring(1)) + func(s.substring(2));
    }



    public static void main(String[] args) {

    }
}
