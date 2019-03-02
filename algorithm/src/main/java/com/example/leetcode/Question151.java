package com.example.leetcode;

/**
 * @author ximu
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/8/12
 */
public class Question151 {

    public static String reverseWords(String s) {
        //翻转字符串
        String str = new StringBuilder(s.trim()).reverse().toString();
        if (str.length()<=1){
            return str;
        }
        int i=0, j=0;
        StringBuilder sb = new StringBuilder();
        while (j<str.length()){
            while ( j<str.length() && (str.charAt(j) != ' ')){
                j++;
            }
            sb.append(new StringBuilder(str.substring(i, j)).reverse());
            sb.append(' ');
            while (j<str.length() && str.charAt(j) == ' '){
                j++;
            }
            i = j;
        }
        String ret = sb.toString();
        return ret.substring(0, ret.length()-1);
    }




    public static void main(String[] args) {

        System.out.println(reverseWords("   a   b "));
    }
}
