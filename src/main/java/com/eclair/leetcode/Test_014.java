package com.eclair.leetcode;/**
 * @author
 * @date
 **/

/**
 * @Author
 * @Time 2021/3/18 10:59
 * @Description
 **/
public class Test_014 {
    public static void main(String[] args) {
//        String[] strs = {"ab", "a"};
//        String[] strs1 = {"flower","flow","flight"};
//        System.out.println("sss=   " + longestCommonPrefix(strs));
        String a = "@231";
        System.out.println("aaa ===  " + a.substring(0,0));
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int index = 0;
        char indexChar;
        boolean breakOut = true;
        // 获取第一个字符串前缀往后匹配
        while(breakOut) {
            if (strs[0].length()-1 < index) {
                break;
            }
            indexChar = strs[0].charAt(index);
            for (int i = 1;i<strs.length;i++) {
                if (index > strs[i].length()-1 || strs[i].charAt(index) != indexChar) {
                    breakOut = false;
                    break;
                }
            }
            index++;
        }
        if (!breakOut) {
            index--;
        }
        return strs[0].substring(0,index);
    }
}
