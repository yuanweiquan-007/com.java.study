package com.java.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/15 10:41 下午
 */
@Slf4j
public class Case_ReentrantReadWriteLock {

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public void cases() throws Exception {
        new Thread(() -> {
            try {
                writeLock.lock();
                Thread.sleep(1000);
                log.info("write");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        }, "Read1").start();

        Thread.sleep(500);

        new Thread(() -> {
            try {
                readLock.lock();
                log.info("read");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        }, "Read2").start();

        Thread.sleep(100);
    }

    public static void main(String[] args) throws Exception {
        Case_ReentrantReadWriteLock case_lock = new Case_ReentrantReadWriteLock();
        case_lock.cases();
    }

}
