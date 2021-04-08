package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.node.ListNode;

/**
 * @Author
 * @Time 2021/3/19 16:10
 * @Description
 **/
public class Test_021 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.addNext(2).addNext(3);
        ListNode l2 = new ListNode(1);
        l2.addNext(2).addNext(4);
        final ListNode listNode = mergeTwoLists01(l1, l2);
        System.out.println(listNode);
    }
    public static ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists01(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists01(l1,l2.next);
            return l2;
        }
    }
}
