package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x248f5/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author
 * @Time 2021/2/26 16:24
 * @Description
 **/
public class test_217 {
    public static void main(String[] args) {

    }

    /**
     * 暴力破解
     * 时间复杂度哦o(n2)
     * @param nums
     * @return
     */
    public static boolean containsDuplicate_01(int[] nums) {
        for(int i = 0;i<nums.length-1;i++) {
            for(int j = i+1;j<nums.length;j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 时间on
     * 空间on
     * 通过放set中存放值，判断set长度和数组长度比较是否存在重复值
     * @param nums
     * @return
     */
    public static boolean containsDuplicate_02(int[] nums) {
     Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }
     return set.size() == nums.length;
    }

    /**
     * 时间复杂度：O(NlogN)，其中 NN 为数组的长度。需要对数组进行排序。
     *
     * 空间复杂度：O(logN)，其中 NN 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
     * 对数组排序
     * 遍历数组，当前数和洗衣柜数如果相等就表明存在重复元素
     * @param nums
     * @return
     */
    public static boolean containsDuplicate_03(int[] nums) {
        Arrays.sort(nums);
        for (int i =0;i<nums.length-1;i++) {
            if(nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }
}
