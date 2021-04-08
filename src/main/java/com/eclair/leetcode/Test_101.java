package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.tree.TreeNode;

import javax.swing.*;
import java.util.*;

/**
 * @Author
 * @Time 2021/3/24 11:19
 * @Description
 **/
public class Test_101 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2);
        t.left = l;
        t.right = r;
        l.left = new TreeNode(2);
//        l.right = new TreeNode(4);
//        r.left = new TreeNode(2);
        r.right = new TreeNode(2);
        System.out.println(isSymmetric01(t));
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
       Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> list = new ArrayList<>();
        while(queue.size() > 0) {
            int size = queue.size();
            if (size>1&&size%2 != 0) {
                return false;
            }
            while(size -- >0) {
                TreeNode poll = queue.poll();
                if(poll.left != null) {
                    list.add(poll.left.val+"");
                    queue.offer(poll.left);
                }else{
                    list.add("a");
                }
                if(poll.right != null) {
                    list.add(poll.right.val+"");
                    queue.offer(poll.right);
                }else{
                    list.add("a");
                }
            }
                if(!isSymmetric(list)) {
                    return false;
                }
                list.clear();
        }
    return true;

    }

    public  static boolean isSymmetric(List<String> list) {
        int length = list.size();
        int first = 0;
        int last = length - 1;
        while (last > first) {
            if (!list.get(first++).equals(list.get(last--))) {
                return false;
            }
        }

        return true;
    }
    // 递归中序遍历，放到集合，看看是否是回文数组(有问题）
    public static boolean isSymmetric01_error(TreeNode root) {
        List<String> list = new ArrayList<>();
        addValue(root,list);
        System.out.println(list);
        return isSymmetric(list);
    }

    private static void addValue(TreeNode root, List<String> list) {
        if(root == null) {
            list.add("a");
            return;
        }
        boolean add = root.left != null || root.right != null;
        if (add) {
            addValue(root.left,list);
        }
        list.add(root.val+"");
        if(add) {
            addValue(root.right,list);
        }
    }

    public static boolean isSymmetric01(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left,root.right);
    }

    private static boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return l.val == r.val && check(l.left,l.right) && check(r.left,r.right);
    }
}
