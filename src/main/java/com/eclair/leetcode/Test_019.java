package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.node.ListNode;

import java.util.Stack;

/**
 * @Author
 * @Time 2021/3/19 11:10
 * @Description
 **/
public class Test_019 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.addNext(2);
        System.out.println(node);
        final ListNode listNode = removeNthFromEnd02(node, 1);
        System.out.println(listNode);
    }
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while(node != null) {
            node = node.next;
            length++;
        }
        if (n==length) {
            return head != null ? head.next : null;
        }
        // 定位到要删除节点的前面一个 从正数数为 长度-n+1 个 其前一个在减1
        int update = length - n + 1 - 1;
        int index  = 1;
        ListNode predel = head;
        // 获取删除节点前一个节点
        while(index != update) {
            predel = predel.next;
            index++;
        }
        ListNode isDel = predel.next;
        predel.next = isDel.next;
        isDel.next = null;
      return head;
    }
    public static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while (node != null) {
            // 获取下一个指针
            next = node.next;
            // 当前指针下一个节点为先前节点
            node.next = pre;
            // 先前节点改为当前节点·
            pre = node;
            // 当前节点为下一个节点
            node = next;
        }
        return pre;
    }
    // 通过stack来反向得到要删除的节点
    public static ListNode removeNthFromEnd01(ListNode head, int n) {
        ListNode res = new ListNode(0,head);
        Stack<ListNode> stack = new Stack<>();
        ListNode currentNode = res;
        // 每个链表节点放入栈
        while(currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
//        放入栈后顺序反转，获取第n个就是要删除的那一个
        for(int i = 0; i < n ;i++) {
            stack.pop();
        }
        ListNode prefixDelNode = stack.peek();
        prefixDelNode.next = prefixDelNode.next.next;
        return res.next;
    }
    // 双向指针遍历
    public static ListNode removeNthFromEnd02(ListNode head, int n) {
        ListNode res = new ListNode(0,head);
        ListNode res1= res;
        ListNode first = head;
        for (int i = 0;i<n;i++) {
            first = first.next;
        }
        // 遍历到达删除节点前一个节点
        while(first!=null) {
            res = res.next;
            first = first.next;
        }
        // 当前res为需要删除节点的前一个节点
        res.next = res.next.next;
        return res1.next;
    }
}
