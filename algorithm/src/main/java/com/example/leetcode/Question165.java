package com.example.leetcode;

/**
 * @author ximu
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/8/13
 */
public class Question165 {

    /**
     * version1 = "7.5.2.4", version2 = "7.5.2"
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int i1=0, j1=0;
        int i2=0, j2=0;
        while (j1<version1.length() && j2<version2.length()){
            while (j1<version1.length() && version1.charAt(j1) != '.'){
                j1++;
            }
            Integer v1 = Integer.valueOf(version1.substring(i1, j1));
            j1++;
            i1 = j1;

            while (j2<version2.length() && version2.charAt(j2) != '.'){
                j2++;
            }
            Integer v2 = Integer.valueOf(version2.substring(i2, j2));
            j2++;
            i2 = j2;

            if (v1 > v2){
                return 1;
            } else if (v1 < v2){
                return -1;
            }
        }
        // 已有的数据比较完了
        if (j1 >= version1.length() && j2 < version2.length()){
            // version1已经遍历完了, version2还没有遍历完
            // 判断version2后面的部分是否全部是0
            String v2 = version2.substring(j2);
            if (check(v2)){
                return -1;
            }
            return 0;
        }
        if (j1 >= version1.length() && j2 >= version2.length()){
            // version1已经遍历完了, v2也比较完了
            return 0;
        }
        if (j1 < version1.length() && j2 >= version2.length()){
            String v1 = version1.substring(j1);
            if (check(v1)){
                return 1;
            }
            return 0;
        }
        return 1;
    }


    private static boolean check(String s){
        return s.contains("1") || s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") ||
            s.contains("7") || s.contains("8") || s.contains("9");
    }

    public static void main(String[] args) {
        String s = "111";
        String[] ss = s.split(".");
        System.out.println(ss.length);
        System.out.println(ss[0]);
    }




}
