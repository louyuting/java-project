package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ximu
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/8/13
 */
public class Question3 {

    public static int lengthOfLongestSubstring(String s) {

        if(s.length()==0){
            return 0;
        }

        int i=0, j=1;
        Set<Character> existed = new HashSet<>();
        int maxLen = 1;

        existed.add(s.charAt(i));
        while (j<s.length()){

            if (existed.contains(s.charAt(j))){
                //当前集合中已经存在该字符，表示出现重复字符串
                if (existed.size() > maxLen){
                    maxLen = existed.size();
                }
                char duplicate = s.charAt(j);
                while (s.charAt(i) != duplicate){
                    i++;
                }
                i++;
                j = i+1;
                existed.clear();
                existed.add(s.charAt(i));
            } else {
                existed.add(s.charAt(j));
                j++;
            }
        }
        if (existed.size() > maxLen){
            maxLen = existed.size();
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }



}
