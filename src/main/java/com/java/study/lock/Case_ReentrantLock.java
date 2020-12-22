package com.java.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/13 9:45 下午
 */
@Slf4j
public class Case_ReentrantLock {

    private ReentrantLock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();

    public void interrupt() throws Exception {
        Thread thread = new Thread(() -> {
            try {
                lock.lockInterruptibly();
                log.info("获取中断锁");
            } catch (InterruptedException ex) {
                log.info("lock被中断");
            } finally {
                lock.unlock();
            }
        }, "thread");

        lock.lock();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    /**
     * 多条件
     */
    public void condition() {
        Integer max = 10;
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (list.size() >= max) {
                        isFull.await();
                    } else {
                        int value = random.nextInt(100);
                        list.add(value);
                        log.info("{}加入集合成功", value);
                        isEmpty.signal();
                    }
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "addThread").start();

        new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (list.isEmpty()) {
                        isEmpty.await();
                    } else {
                        Integer value = list.remove(0);
                        log.info("{}消费成功", value);
                        isFull.signal();
                        Thread.sleep(1000);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "getThread").start();
    }

    /**
     * 锁重入
     */
    public void reentrantLock() {
        try {
            lock.lock();
            log.info("获取锁成功");
            try {
                lock.lock();
                log.info("锁重入成功");
            } finally {
                lock.unlock();
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 锁超时
     */
    public void lockTimeOut() throws InterruptedException {
        new Thread(() -> {
            lock.lock();
            try {
                log.info("拿到锁休眠5秒");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
            log.info("等到2秒拿到锁");
        }
        log.info("执行完成");
    }

    public static void main(String[] args) throws Exception {
        Case_ReentrantLock reentrantLock = new Case_ReentrantLock();
//        reentrantLock.reentrantLock();
//        reentrantLock.lockTimeOut();
//        reentrantLock.condition();
        reentrantLock.interrupt();
//        Thread.sleep(Integer.MAX_VALUE);
    }

}
