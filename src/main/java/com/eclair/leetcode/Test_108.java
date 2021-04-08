package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.tree.TreeNode;

/**
 * @Author
 * @Time 2021/3/26 11:11
 * @Description
 **/
public class Test_108 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int arrayLength = getLength(nums.length);
        if (nums.length == 0) {
            return null;
        }
        return getTreeNode(nums,0,nums.length-1);
    }

    public static TreeNode getTreeNode(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int mid = (right - left)/2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getTreeNode(nums,left,mid-1);
        node.right = getTreeNode(nums,mid+1,left);
        return node;
    }

    public static int getLength(int length) {
        int power = 0;
        int res = 0;
        while (length > 0) {
            int reduce = (int) Math.pow(2, power++);
            length = length - reduce;
            res = res + reduce;
        }
        return res;
    }
}