package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author
 * @Time 2021/3/10 11:06
 * @Description
 **/
public class Test_387 {
    public static void main(String[] args) {
        int a = firstUniqChar03("aabcbddcasffe");
        System.out.println(a);
    }
    public static int firstUniqChar01(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        int index = 0;
        for(char c:s.toCharArray()){
            int a = (int)c;
            res = res^a;
            map.put(c,index++);
        }
        if(res == 0) {
            return -1;
        }
        char c = (char)res;
        return map.get(c);
    }
    public static int firstUniqChar02(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        char[] cs = s.toCharArray();
        for(int i = 0;i<cs.length;i++) {
            if(map.get(cs[i]) == null) {
                map.put(cs[i],1);
            }else{
                map.put(cs[i],map.get(cs[i])+1);
            }
        }
        final Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for(Map.Entry<Character, Integer> ent:entries) {
            if(ent.getValue().equals(1)) {
                return s.indexOf(ent.getKey());
            }
        }
        return -1;
    }
    public static int firstUniqChar03(String s) {
        final char[] chars = s.toCharArray();
        for(int i=0;i<s.length();i++) {
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i])){
                return i;
            }
        }
        return -1;
    }
}
