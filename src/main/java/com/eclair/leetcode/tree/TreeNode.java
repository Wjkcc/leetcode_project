package com.eclair.leetcode.tree;/**
 * @author
 * @date
 **/

/**
 * @Author
 * @Time 2021/3/23 11:28
 * @Description
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      public void print(TreeNode node) {
          if (node.left != null) {
              print(node.left);
          }
          System.out.print(node);
          if(node.right!=null) {
              print(node.right);
          }
      }

}
