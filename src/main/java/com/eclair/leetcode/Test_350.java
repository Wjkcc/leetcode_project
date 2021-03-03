package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.*;

/**
 * @Author
 * @Time 2021/3/2 14:50
 * @Description
 **/
public class Test_350 {
    public static void main(String[] args) {
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
//        intersect(nums1,nums2);

        int[] input = {55,0,20,9,9,9,1,2,1};
        mp(input);
        for (int i : input) {
            System.out.print(i + ",");
        }
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        if (nums1.length > nums2.length) {
            for (int i:nums1) {
                if (map1.containsKey(i)) {
                    map1.put(i, map1.get(i)+1);
                }else {
                    map1.put(i,1);
                }
            }
           for(int i: nums2) {
               if (map1.containsKey(i) && map1.get(i) > 0) {
                   res.add(i);
                   map1.put(i,map1.get(i)-1);
               }
           }
        }else {
            for (int i:nums2) {
                if (map1.containsKey(i)) {
                    map1.put(i, map1.get(i)+1);
                }else {
                    map1.put(i,1);
                }
            }
            for(int i: nums1) {
                if (map1.containsKey(i) && map1.get(i) > 0) {
                    res.add(i);
                    map1.put(i,map1.get(i)-1);
                }
            }
        }
        int a[] = new int[res.size()];
       for (int i = 0;i < res.size();i++) {
           a[i] = res.get(i);
           System.out.println(a[i]);
       }
        return a;
    }
    public static int[] intersect01(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
    public static int[] str(int[] digits) {
        String a = "";
        for(int i: digits) {
            a = a + i;
        }
        Long i = Long.parseLong(a) + 1;
        String s = String.valueOf(i);
        int[] res = new int[s.length()];
        int index = 0;
        for(char c :s.toCharArray()) {
           int integer = Character.getNumericValue(c);
            res[index] = integer;
            index++;
        }
        return res;
    }

    public static int[] str1(int[] digits) {
        int last = digits.length - 1;
        final int digit = digits[0];
        int i = digits[last] + 1;
        if(i == 10) {
            getLast(last,digits,true);
        }else {
            digits[last] = i;
        }
        int[] res = new int[digits.length +1];
        if (digits[0] == 0 && digit != 0) {
            res[0]=1;
            return res;
        }
        return digits;
    }
    public static void getLast(int index,int[] digits,boolean add) {
        if (index == 0) {
       digits[index] = 0;
       return;
        }
        if (add) {
            int i = digits[index] + 1;
            if (i == 10) {
                digits[index] = 0;
                getLast(index - 1,digits,true);
            }
            else {
                digits[index] = i;
            }
        }
    }

    public static int[] str3(int[] digits) {
        for (int i = digits.length - 1;i>=0; i--) {
            digits[i]++;
            if (digits[i]%10 != 0) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }

    public static void mp(int[] num){
        for(int i = 0;i<num.length-1 ;i++) {
            for (int j = 0;j<num.length-1-i;j++) {
                if(num[j] > num[j+1]) {
                        int temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                }
            }
        }
    }
    public static void xz(int[] num){
        for(int i = 0;i<num.length-1 ;i++) {
            for (int j = i+1;j<num.length;j++) {
                if(num[i] > num[j]) {
                    int temp = num[j];
                    num[j] = num[i];
                    num[i] = temp;
                }
            }
        }
    }
}
