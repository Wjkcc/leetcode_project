package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author
 * @Time 2021/3/23 11:27
 * @Description
 **/
public class Test_104 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return getMax( root);
    }
    public static int getMax(TreeNode root) {
        int maxDepth = 0;
        return getMax(root,0);
    }
    public static int getMax(TreeNode root,int dep){
        if (root != null) {
            dep++;
            return Math.max(getMax(root.left,dep),getMax(root.right,dep));
        }
        return dep;
    }

    /**
     * 优先算法
     * 假设先知道了 树的左边和右边深度，最大深度就位左右较大值加1，左右节点也是一样进行递归
     * @param root
     * @return
     */
    public static int maxDepth01(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // 左子树深度
        int left = maxDepth01(root.left);
        // 右子树深度
        int right = maxDepth01(root.right);
        return Math.max(left,right) + 1;
    }
    // 广度优先算法
    public static int maxDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 现进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while(queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    queue.offer(poll.left);
                }
                if(poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
          res++;

        }
        return res;
    }

}
