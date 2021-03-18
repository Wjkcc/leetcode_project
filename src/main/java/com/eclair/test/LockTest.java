package com.eclair.test;/**
 * @author
 * @date
 **/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author
 * @Time 2021/3/10 14:07
 * @Description
 **/
public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> {

            lock.lock();
            try {
                System.out.println("start");
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
            lock.unlock();
        },"thread-1").start();


        new Thread(() -> {

            lock.lock();
            try {
                System.out.println("start2");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end2");
            lock.unlock();
        },"thread-2").start();
    }
}
