package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.Arrays;

/**
 * @Author
 * @Time 2021/3/29 11:04
 * @Description
 **/
public class Test_88 {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        int m = 1;
        int n = 1;
        merge02(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (m==0) {
//
//            return;
//        }
//        if (n==0) {
//            return;
//        }
        for (int i = 0;i<n;i++) {
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
    // 倒叙排列
    // 大的往后放
    // 圈闭比完后，假如nums2还有多
    // 把nums2朵的放到nums1最前面
    public static void merge01(int[] nums1, int m, int[] nums2, int n) {
        if(m== 0 && n != 0) {
            for (int i = 0;i<n;i++) {
                nums1[i+m] = nums2[i];
            }
        }
        int cur = m+n-1;
        m = m-1;
        n = n-1;
        while (m >= 0 && n >= 0) {
         if (nums1[m] > nums2[n] ) {
             nums1[cur--] = nums1[m--];
          }else {
             nums1[cur--] = nums2[n--];
         }
        }
        if (n>=0) {
            for (int i = 0; i<=n;i++) {
                nums1[i] = nums2[i];
            }
        }
    }
    public static void merge02(int[] nums1, int m, int[] nums2, int n) {
        int[] a = new int[m+n];
        int i1 = 0;
        int i2 = 0;
        int cur = 0;
        while (i1 < m && i2 < n) {
            if (nums1[i1] > nums2[i2]) {
                a[cur++] = nums2[i2++];
            }else {
                a[cur++] = nums1[i1++];
            }
        }
        if (i1 < m) {
            for(int i = i1;i<m;i++) {
                a[cur++] = nums1[i];
            }
        }
        if (i2 < n) {
            for(int i = i2;i<n;i++) {
                a[cur++] = nums2[i];
            }
        }
       for(int i = 0; i < a.length;i++) {
           nums1[i] = a[i];
       }
    }
}
