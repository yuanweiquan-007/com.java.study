package com.java.study.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 模拟线程休眠
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/16 5:15 下午
 */
@Slf4j
public class Case_ThreadSleep {

    public static void sleep(long mills) throws Exception {
        if (mills <= 0) {
            throw new Exception("sleep time must be greater than 0");
        }

        long sleepTime = 0;
        long endTime = System.currentTimeMillis() + mills;//休眠的截止时间
        Thread currentThread = Thread.currentThread();
        while (System.currentTimeMillis() < endTime) {
            synchronized (currentThread) {
                sleepTime = endTime - System.currentTimeMillis();//计算剩余休眠时间，防止休眠的过程中被欢唤醒
                currentThread.wait(sleepTime);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        log.info("start");
        Thread thread = Thread.currentThread();
        new Thread(() -> {
            while (true) {
                synchronized (thread) {
                    thread.notifyAll();
                    log.info("{} is be notify", thread.getName());
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "notifyThread").start();
        Case_ThreadSleep.sleep(5000);
        log.info("end");
    }

}
