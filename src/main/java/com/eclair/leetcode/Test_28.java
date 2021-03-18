package com.eclair.leetcode;/**
 * @author
 * @date
 **/

/**
 * @Author
 * @Time 2021/3/16 11:26
 * @Description
 **/
public class Test_28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        final int i = haystack.indexOf(needle);
        System.out.println("i==="+i);
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null) {
            return -1;
        }
        if ((haystack.trim().length() == 0 && needle.trim().length() !=0) ) {
            return -1;
        }
        if ((haystack.trim().length() == 0 && needle.trim().length() ==0) || (haystack.trim().length() != 0 && needle.trim().length() ==0)) {
            return 0;
        }
        int h_index = 0;
        int n_index = 0;
        while(h_index < haystack.length() ) {
            if (haystack.charAt(h_index) == needle.charAt(n_index)) {
                if (n_index+1 >= needle.length() ) {
                    return h_index - n_index;
                }
                h_index++;
                n_index++;
                continue;
            }
            // 再次从第一次匹配的下一个进行匹配
            if(n_index != 0) {
                h_index = h_index - n_index + 1;
                n_index = 0;
                continue;
            }
            h_index++;

        }
        return -1;
    }
}
