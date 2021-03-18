package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * @Author
 * @Time 2021/3/4 13:52
 * @Description
 **/
public class Test_001 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            int search = target - nums[i];
            if (map.containsKey(search)) {
                res[0] = map.get(search);
                res[1] = i;
                break;
            }else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
}
