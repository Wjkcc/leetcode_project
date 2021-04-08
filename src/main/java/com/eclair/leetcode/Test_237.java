package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.node.ListNode;

/**
 * @Author
 * @Time 2021/3/19 10:58
 * @Description
 **/
public class Test_237 {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
