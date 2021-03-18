package com.eclair.leetcode;/**
 * @author
 * @date
 **/

/**
 * @Author
 * @Time 2021/3/9 13:26
 * @Description
 **/
public class Test_007 {
    public static void main(String[] args) {
        System.out.println(reverse01(123));
    }
    public static int reverse01(int x) {
        if (x == 0) {
            return 0;
        }
        int res = 0;
        while(x > 0) {
            int add = x%10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && add > Integer.MAX_VALUE % 10)){
                res = 0;
                break;
            }else if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && add < Integer.MIN_VALUE % 10)){
                res = 0;
                break;
            }
            res = res*10 + add;
            x = x/10;
        }
        return res;
    }
}
