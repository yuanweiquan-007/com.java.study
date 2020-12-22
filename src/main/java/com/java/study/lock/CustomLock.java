package com.java.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 自定义锁
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/16 9:09 下午
 */
@Slf4j
public class CustomLock {

    private CustomSync sync = new CustomSync();

    public void lock() {
        sync.acquire(1);
    }

    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    public void unlock() {
        sync.release(1);
    }


    public static void main(String[] args) throws Exception {
        CustomLock customLock = new CustomLock();

        new Thread(() -> {
            if (customLock.tryLock()) {
                log.info("线程1拿到锁");
            }
        }, "Thread1").start();

        customLock.lock();
        log.info("主线程拿到锁");

        Thread.sleep(2000);
        customLock.unlock();
        log.info("主线程解锁");

        TimeUnit.SECONDS.sleep(2);
        log.info("结束");
    }

}
