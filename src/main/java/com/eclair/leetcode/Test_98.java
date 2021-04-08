package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author
 * @Time 2021/3/23 15:15
 * @Description
 **/
public class Test_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        System.out.println(isValidBST01(root));
    }
    // 把二叉树中的数据放到一个list中，比较list是否排序正确
    public static boolean isValidBST01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getValue(list,root);
        for (int i = 0;i<list.size()-1;i++) {
            if (list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static void getValue(List<Integer> list,TreeNode root) {
        if (root == null) {
            return;
        }

            getValue(list,root.left);
        list.add(root.val);
            getValue(list,root.right);

    }
    // 广度优先算法实现 error,有问题
    public static boolean isValidBST02(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() > 0) {
            TreeNode poll = queue.poll();
            int mid = poll.val;
            int left = (poll.left == null ? mid - 1:poll.left.val);
            int right = (poll.right == null ? mid + 1:poll.right.val);
            if (mid < left || mid > right) {
                return false;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return true;
    }
    // 递归算法
    public static boolean isValidBST03(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValidBST02(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    // 递归操作，点前值需要小于最大值，大于最小值
    // 对于右节点来说，最大值是max，最小值为根节点
    // 对于左节点来说，最大值根节点，最小值为min
    public static boolean isValidBST02(TreeNode p,int max,int min) {
        if (p == null) {
            return true;
        }
        if (p.val >= max || p.val <= min) {
            return false;
        }
        return isValidBST02(p.left,p.val,min) && isValidBST02(p.right,max,p.val);
    }
}
