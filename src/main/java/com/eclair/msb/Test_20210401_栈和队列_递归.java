package com.eclair.msb;/**
 * @author
 * @date
 **/

import java.util.Queue;
import java.util.Stack;

/**
 * @Author
 * @Time 2021/4/1 11:30
 * @Description
 **/
public class Test_20210401_栈和队列_递归 {
    public static void main(String[] args) {

    }

    /**
     * 实现一个栈
     * pop和push时间复杂度都为O1
     * 有一个getMin方法，获取栈中最小值，时间复杂度也为O1
     * @param <T>
     */
    public static class MyStack<T extends Comparable<T>> {
        // 存储值
        private Stack<T> stack;
        // 存放最小值，每次有值添加进来，和栈顶进行比较
        // 假如添加值比栈顶小，吧值push进去
        // 否则再次push一次栈顶值
        private Stack<T> minStack;

        public MyStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public boolean push(T t) {
            if (stack.isEmpty()) {
                return false;
            }
             T peek = minStack.peek();
            if (peek != null && t.compareTo(peek) > 0) {
                minStack.push(peek);
            }
            else{
                minStack.push(t);
            }
            stack.push(t);
            return true;
        }

        public T pop() {
            if (stack.isEmpty()) {
                return null;
            }
            final T pop = stack.pop();
            minStack.pop();
            return pop;
        }
        public T getMin() {
            return minStack.peek();
        }
    }

    /**
     * 用列队实现栈的功能
     * @param <T>
     */
    public static class MyStack_queue<T> {
        /**
         * 添加队列，每次入队都加到这个队列当中去
         */
        Queue<T> pushQueue;
        /**
         * 出队队列，每次出队，吧pushQueue中的元素添加到这个队列，pushQueue只留一个在其中，吧最后一个弹出，就是出栈
         * 两个队列彼此交换
         */
        Queue<T> popQueue;
        public boolean push(T t) {
            pushQueue.offer(t);
            return true;
        }
        public  T pop() {
            if (pushQueue.isEmpty()) {
                return null;
            }
           if (pushQueue.size() == 1) {
                T poll = pushQueue.poll();
           }
           while(pushQueue.size()>1) {
               final T poll = pushQueue.poll();
               popQueue.offer(poll);
           }
            final T poll = pushQueue.poll();
           Queue<T> temp = pushQueue;
           pushQueue = popQueue;
           popQueue = temp;
           return poll;
        }
    }
    /*
    用栈实现队列的功能
     */
    public static class MyQueue_stack<T> {
        Stack<T> push = new Stack<>();
        Stack<T> pop = new Stack<>();
        public boolean push(T data) {
            push.push(data);
            if (pop.isEmpty()) {
                pushToPop();
            }
            return true;
        }
        public void pushToPop() {
            while(pop.isEmpty()) {
                while(!push.isEmpty()) {
                    pop.push(push.pop());
                }
            }
        }
        public  T pop() {
            if (!push.isEmpty() && pop.isEmpty()) {
                pushToPop();
            }
            if (pop.isEmpty()) {
                return null;
            }
            return pop.pop();
        }
    }
}
