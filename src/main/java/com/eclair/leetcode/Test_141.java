package com.eclair.leetcode;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.node.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author
 * @Time 2021/3/22 14:46
 * @Description
 **/
public class Test_141 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(22);
        ListNode node3 = new ListNode(11);
        node.next = node1;
        node.next.addNext(2).addNext(3).addNext(4).next = node3;
        node3.next = node;
        System.out.println(hasCycle01(node));
    }


    public static boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while(head!=null) {
          if (set.contains(head)) {
              return true;
          }
          set.add(head);
          head = head.next;
        }
        return false;
    }
    // 慢指针和快指针

    /**
     * 快指针每次移动2，慢指针每次移动1
     * 加入有环形，指针会相遇
     *
     * @param head
     * @return
     */
    public static boolean hasCycle01(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }

        }
        return true;

    }
}
