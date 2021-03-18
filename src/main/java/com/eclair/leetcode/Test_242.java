package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author
 * @Time 2021/3/11 14:08
 * @Description
 **/
public class Test_242 {
    public static void main(String[] args) {
        boolean a = isAnagram("abc","cba");
        System.out.println(a);
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            // 合并操作
            // 加入key不存在，设置value为1，否则value与1求和操作
            map.merge(c, 1, Integer::sum);
        }
        for (char c : t.toCharArray()) {
            if (map.get(c) == null) {
                return false;
            }
            int i = map.get(c)-1;
           if (i == 0) {
               map.remove(c);
               continue;
           }
           map.put(c,i);
        }
        return map.isEmpty();
    }
    public static boolean isAnagram01(String s, String t) {

        return false;
    }
}
