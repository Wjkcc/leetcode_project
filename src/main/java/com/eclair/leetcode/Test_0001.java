package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author
 * @Time 2021/3/4 10:59
 * @Description
 **/
public class Test_0001 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,3,0,22,3,0,1};
        moveZeroes03(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
        int zero = 0;
        int index = 0;
        int last = nums.length - 1;
        while (zero <= last && index <= last) {
//            if (nums[zero] == 0 && nums[index] == 0) {
//                index++;
//                continue;
//            }
//            else if (nums[zero] == 0 && nums[index] != 0) {
//                int temp = nums[zero];
//                nums[zero] = nums[index];
//                nums[index] = temp;
//            }
//            zero++;
//            index++;
            if (nums[zero] == 0) {
                if (nums[index] != 0) {
                    int temp = nums[zero];
                    nums[zero] = nums[index];
                    nums[index] = temp;
                    zero++;
                    index++;
                }else {
                    index++;
                }
            }else {
                zero++;
                index++;
            }
        }
    }

    public static void moveZeroes01(int[] nums) {
        int next = 0;
        int index = 0;
        int last = nums.length;
        while(next < last) {
            if (nums[next] != 0) {
                nums[index] = nums[next];
                index++;
            }
                next++;

        }
        for(int i = index;i<last;i++) {
            nums[i] = 0;
        }
    }
    public static void moveZeroes03(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            if (num != 0) {
                res[index] = num;
                index++;
            }
        }
        System.arraycopy(res,0,nums,0,nums.length);
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
                map.put(search,i);
            }
        }
        return res;
    }
}
