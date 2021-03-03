package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * @Time 2021/3/1 13:26
 * @Description
 **/
public class Test_000 {
    public static void main(String[] args) {
        int[] nums = {2,2,1};
        singleNumber01(nums);
    }

    public static int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
       for (int j = 0;j < nums.length;j++) {
           if (!map.containsKey(nums[j])) {
               map.put(nums[j],j);
           }else {
               map.remove(nums[j]);
           }
       }
       AtomicInteger res = new AtomicInteger();
       map.forEach((k,v) -> {
           res.set(v);
       });
        System.out.println(map);
        return res.get();
    }

    public static int singleNumber01(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0;i<nums.length - 1;i = i+2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }

    public int singleNumber03(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
