package com.eclair.leetcode;/**
 * @author
 * @date
 **/

/**
 * @Author
 * @Time 2021/3/15 15:58
 * @Description
 **/
public class Test_008 {
    public static void main(String[] args) {
        String s = "000021474836460";
        System.out.println("---  "+Integer.MAX_VALUE);
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s) {
        String num = s.trim();
        if(num.length() == 0) {
            return 0;
        }
        boolean negitive = num.startsWith("-");
        if(negitive || num.startsWith("+")) {
            num = num.substring(1);
        }
        char[] cs = num.toCharArray();
        StringBuffer sb = new StringBuffer();
        int index = 0;
        for(int i = 0; i<cs.length&&index<11;i++) {
            if (sb.length() ==0 && cs[i] == '0') {
                continue;
            }
            if (cs[i]>='0'&&cs[i] <= '9') {
                sb.append(cs[i]);
                index++;
            }else{
                break;
            }
        }
        if (sb.length() == 0) {
            return 0;
        }
        long int_min = (long)Integer.MAX_VALUE + 1;
        long res = Long.parseLong(sb.toString());
        if (negitive &&  res >= int_min) {
            return Integer.MIN_VALUE;
        }else if(negitive && res < int_min) {
            return (int)(-1*res);
        }else if(!negitive && res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }else {
            return (int)res;
        }
    }
}
