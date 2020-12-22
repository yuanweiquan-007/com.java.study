package com.java.study.lock;

/**
 * 死锁
 */
public class Case_DeadLock {
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (a) {
                System.out.println("1");
                synchronized (b) {
                    System.out.println("2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (b) {
                System.out.println("3");
                synchronized (a) {
                    System.out.println("4");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
