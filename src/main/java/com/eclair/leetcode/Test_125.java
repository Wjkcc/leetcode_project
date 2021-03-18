package com.eclair.leetcode;/**
 * @author
 * @date
 **/

/**
 * @Author
 * @Time 2021/3/12 11:17
 * @Description
 **/
public class Test_125 {
    public static void main(String[] args) {
        String s = "0p";
        System.out.println(isPalindrome03(s));
    }
    public static boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        if(s.trim().length() <= 1) {
            return true;
        }
        StringBuffer sb = new StringBuffer();
        char[] cs = s.trim().toLowerCase().toCharArray();
        for(char c : cs) {
            if ((c >=97 && c <=122) || (c>=48 && c<=57)) {
                sb.append(c);
            }
        }
        int first = 0;
        int last = sb.length()-1;
        for(int i = 0;i<sb.length()/2;i++) {
            if (sb.charAt(first++) != sb.charAt(last--)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome01(String s) {
        final char[] chars = s.trim().toLowerCase().toCharArray();
        int first = 0;
        int last = chars.length-1;
      while(first < last) {
        if(!isLetter(chars[first])) {
            first++;
            continue;
        }
        if (!isLetter(chars[last])) {
            last--;
            continue;
        }
        if(chars[first++] != chars[last--]) {
            return false;
        }
      }
      return true;
    }
    public static boolean isLetter(char c) {
        if ((c >=97 && c <=122) || (c>=48 && c<=57)) {
            return true;
        }
        return false;
    }
    public static boolean isPalindrome02(String s) {
        if (s == null) {
            return false;
        }
        if(s.trim().length() <= 1) {
            return true;
        }
        StringBuffer sb = new StringBuffer();
        char[] cs = s.trim().toLowerCase().toCharArray();
        for(char c : cs) {
            if ((c >=97 && c <=122) || (c>=48 && c<=57)) {
                sb.append(c);
            }
        }
        int med = sb.length()/2;
        String left = sb.substring(0,med);
        StringBuffer r = new StringBuffer();
        for(int i = sb.length()-1;i>=sb.length()-med;i--) {
            r.append(sb.charAt(i));
        }
        return left.equals(r.toString());
    }
    public static boolean isPalindrome03(String s) {
        s = s.trim().toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left < right) {
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
                continue;
            }
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
       return true;
    }
}
