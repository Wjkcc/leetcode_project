package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author
 * @Time 2021/3/17 9:38
 * @Description
 **/
public class Test_038 {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(1);
        System.out.println(countAndSay(n));
    }
    public static String countAndSay(int n) {
        if (n == 1) {
            return  "1";
        }
        String pre = countAndSay(n-1);
        int length = pre.length();
        int index = 0;
        StringBuffer res = new StringBuffer();
        int l = 1;
        char now;
        while(index < length -1) {
            now = pre.charAt(index);
            // 当前与下一个相同，长度加1
            if(now == pre.charAt(index+1)) {
                index++;
                l++;
            }else{
                res.append(l).append(now);
                l = 1;
                index++;
            }
        }
        // 最后一位添加
        res.append(l).append(pre.charAt(index));
        return res.toString();
    }
}
