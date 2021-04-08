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
        String[] strs = {"ab", "a"};
        String[] strs1 = {"leets","leetcode","leeds","leetc"};
        System.out.println("sss=   " + longestCommonPrefix01(strs1));
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
    // 进行二分查找 找到最短字符中位串 比较每个字符串是否匹配
    public static String longestCommonPrefix01(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        // 获取字符串数组最短长度的一位
        for(String str : strs) {
            min = Math.min(min,str.length());
        }
        int left = 0;
        int right = min;
        while (left < right) {
            // 加1是因为left没有加1
            int mid = (right-left)/2 +left;
            if (matchPrefix(strs,mid)) {
                // 可能就是mid长度
                left = mid;
            }else {
                right = mid-1;
            }
        }
        return  strs[0].substring(0,left);
    }
    // 匹配长度为length的前缀
    private static boolean matchPrefix(String[] strs,int length) {
        String prefix = strs[0].substring(0,length);
        for (String str:strs) {
            for (int i=0;i<length;i++) {
                if(str.charAt(i) != prefix.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
