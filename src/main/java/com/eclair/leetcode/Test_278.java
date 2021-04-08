package com.eclair.leetcode;/**
 * @author
 * @date
 **/

/**
 * @Author
 * @Time 2021/3/30 13:21
 * @Description
 **/
public class Test_278 {
    public static int wrongVersion = 5;
    public static void main(String[] args) {
        int  n = 10;
        System.out.println(firstBadVersion01(n));
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left <= right) {
          int mid = (right-left)/2+left;
          if (isBadVersion(mid)) {
           if (mid >1) {
               if(!isBadVersion(mid-1)) {
                   return mid;
               }else {
                   right = mid-1;
               }
           }else {
              return 1;
           }
          }else {
              if (mid<n) {
                  if (isBadVersion(mid+1)) {
                      return mid+1;
                  }else {
                      left = mid+1;
                  }
              }else{
                 return 0;
              }

          }

        }
        return 0;
    }

    public static boolean isBadVersion(int version) {
        if (version >= wrongVersion) {
            return true;
        }
        return false;
    }

    public static int firstBadVersion01(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
