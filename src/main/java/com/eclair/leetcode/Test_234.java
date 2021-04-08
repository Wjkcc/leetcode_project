package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.node.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author
 * @Time 2021/3/19 17:28
 * @Description
 **/
public class Test_234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.addNext(1).addNext(2).addNext(1);
        System.out.println(isPalindrome04(head));
    }
    public static boolean isPalindrome(ListNode head) {
        // 获取链表长度
        ListNode head1 = head;
        int length = 0;
        while(head1!=null) {
            head1 = head1.next;
            length++;
        }
        // 获取链表后半部分进行反转
        int mid = length%2 == 0 ? length/2 : length/2 +1;
        ListNode head2 = head;
        int index = 0;
        while(index < mid) {
            head2 = head2.next;
            index++;
        }
        ListNode reverseList = reverseList(head2);
        // 比较链表是否回文串
        while(reverseList!=null) {
            if (reverseList.val != head.val) {
                return false;
            }
            reverseList = reverseList.next;
            head = head.next;
        }
        return true;
    }
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while(head!=null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static boolean isPalindrome01(ListNode head) {
        // 通过快慢指针找到后半部分链表
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            // 指针往后两次
            fast = fast.next.next;
        }
        // 如果当前链表长度为奇数，fast不为空，slow往下移动
        if (fast!=null) {
            slow = slow.next;
        }
        ListNode listNode = reverseList(slow);
        // 比较
        while(listNode!=null) {
            if (listNode.val != head.val) {
                return false;
            }
            listNode = listNode.next;
            head = head.next;
        }
        return true;
    }
    // 把链表的值放到数组中，通过双指针比较是否是回文链表
    public static boolean isPalindrome02(ListNode head) {
        ListNode head1 = head;
        List<Integer> list = new ArrayList<>();
        while(head1 !=null) {
            list.add(head1.val);
            head1 = head1.next;
        }
        // 前指针
        int front = 0;
        // 后指针
        int back = list.size() - 1;
        while (front < back) {
            if (!list.get(back--).equals(list.get(front++))) {
                return false;
            }
        }
        return true;
    }
    // 通过栈的先进后出比较是否为回文
    public static boolean isPalindrome03(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode head1 = head;
        while (head1 != null) {
            stack.push(head1.val);
            head1 = head1.next;
        }
        while(head!=null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    // 使用递归方式

    /**
     * 先递归到最后一个
     * 保存一个指针指向第一个
     * 第一次就是第一个和最后一个比较
     * 比较完，指向第一个的指针向后移动一位，指向第二个，此时最后一个递归方法完，向上递归，递归传入的参数为倒数第二个指针
     * 此时倒数第二个和正数第一个进行比较
     *
     * @param head
     * @return
     */
    public static ListNode frontPoint;
    public static boolean isPalindrome04(ListNode head) {
            frontPoint = head;
            return recursivelyCheck(head);
    }

    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode!=null) {
            // 遍历到末尾
            if(!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPoint.val) {
                return false;
            }
            // 指针向后移动
            frontPoint = frontPoint.next;
        }
        return true;
    }
}
