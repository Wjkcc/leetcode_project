package com.eclair.leetcode;/**
 * @author
 * @date
 **/

/**
 *
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 *  
 *
 * 进阶：
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *  
 *
 * 1 2 3 4 5 6 7
 * n=7
 * k=3
 * 0+3/7=3 1 4
 * 4231567
 * 3+3/7=6 4 7
 * 7231564
 * 6+3/7=2 7 3
 * 3271564
 * 2+3/7=5 3 6
 * 6271534
 * 5+3/7=1 6 2
 * 2671534
 * 1+3/7=4 2 5
 * 5671234
 * 4+3/7=0
 * end
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author
 * @Time 2021/2/24 10:26
 * @Description
 **/
public class Test_189 {
    /**
     * 创建一个新的数组，
     * 遍历原数组，吧数据按旋转后顺序插入行数组
     * 把新数组的值赋值到旧的数组
     * @param nums
     * @param k
     */
    public void rotate01(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            // 通过i+k 与n的mod来确定插入的位置
            // i=0 i+k/n = k
            // 说明原数组第1个数想右边移动了k个长度，下同
            // 当i+k>n的时候值为i+k-n ，相当于原数组有变数据加到行数组左边
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    // 数组翻转
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
