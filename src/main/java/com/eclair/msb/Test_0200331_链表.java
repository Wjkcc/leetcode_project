package com.eclair.msb;/**
 * @author
 * @date
 **/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author
 * @Time 2021/3/31 10:51
 * @Description
 **/
public class Test_0200331_链表 {
    public static void main(String[] args) {
        int[] list = {3,2,1,2,3,4,5,6,2,3,2,4,4,2,5};
        Node node = changToNode(list);
//        System.out.println(printNode(node));
//        Node reverseNode = reverseList(node);
//        System.out.println(printNode(reverseNode));
        System.out.println(printNode(node));
         Node node1 = deleteNode(node, 3);

        System.out.println(printNode(node1));
    }
    // 单向链表
    public static class Node{
        Node next;
        int val;
    }
    // 双向链表
    public static class DoubleNode {
        DoubleNode pre;
        DoubleNode next;
        int val;
    }
    /**
     * 链表反转
     * 先获取当前节点下一个节点
     * 吧当前节点洗衣柜节点指向前一个节点
     * 前一个节点成为当前节点
     * 点前节点变成下一个节点
     * @param cur
     * @return
     */
    public static Node reverseList(Node cur) {
        Node pre = null;
        Node next = null;
        while(cur != null) {
            next = cur.next;

            cur.next = pre;

            pre = cur;
            cur = next;
        }
        return pre;
    }
    /**
     * 链表反转
     * 先获取当前节点下一个节点
     * 当前节点洗衣柜节点指向前一个节点
     * 当前节点的前一个节点为当前节点的下一个节点
     * 前一个节点成为当前节点
     * 点前节点变成下一个节点
     * @param cur
     * @return
     */
    public static DoubleNode reverseList(DoubleNode cur) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while(cur != null) {
            next = cur.next;

            cur.next = pre;
            cur.pre = next;

            pre = cur;
            cur = next;
        }
        return pre;
    }
    public static String printNode(Node head) {
        if (head == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer("[");
        while(head!= null) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
    public static Node changToNode(int[] list) {
        if (list.length < 1) {
            return null;
        }
        Node node = new Node();
        node.val = list[0];
        Node cur = node;
        for(int i = 1;i<list.length;i++) {
            cur.next = new Node();
            cur = cur.next;
            cur.val = list[i];
        }
        return node;
    }

    /**
     * 删除点前值为val的节点
     * 返回head
     * @param head
     * @param val
     * @return
     */
    public static Node deleteNode(Node head,int val) {
        while(head != null) {
            if(head.val != val) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while(cur != null) {
            if (cur.val == val) {
                // 找到相同值，就跳过当前节点
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 数组实现stack
     * @param <T>
     */
    public static class ArrayStack<T> {
        int size = 0;
        int maxSize = 100;
        int head = 0;
        int tail = 0;
        Object[] array = new Object[maxSize];
        Lock lock = new ReentrantLock();
        public boolean push(T t) {
            if (hasPlace()) {
                array[head++] = t;
                size++;
             head = nextNum(head);
                return true;
            }
            return false;
        }

        private int nextNum(int num) {
            return num < 99 ? num+1:0;
        }

        public boolean pop() {
            if(!isEmpty()) {
                array[tail++] = null;
                size--;
               tail = nextNum(tail);
                return true;
            }
            return false;
        }
        public boolean isEmpty() {
            return size == 0;
        }
        public boolean hasPlace() {
            return size == maxSize;
        }
    }
}
