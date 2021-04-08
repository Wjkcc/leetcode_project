package com.eclair.leetcode.node;/**
 * @author
 * @date
 **/

import com.eclair.leetcode.Test_019;

/**
 * @Author
 * @Time 2021/3/19 16:10
 * @Description
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   public ListNode addNext(int next) {
        ListNode n = new ListNode(next);
        this.next = n;
        return n;
    }
    @Override
    public  String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[").append(val).append(",");
        ListNode n = this.next;
        while(n != null) {
            sb.append(n.val).append(",");
            n = n.next;
        }
        sb.deleteCharAt(sb.length()-1).append("]");
        return sb.toString();
    }
}
