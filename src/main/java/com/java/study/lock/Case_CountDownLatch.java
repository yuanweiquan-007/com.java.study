package com.java.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/20 11:15 上午
 */
@Slf4j
public class Case_CountDownLatch {
    public static void main(String[] args) throws Exception {
        CountDownLatch downLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                log.info("do somethiing");
                try {
                    Thread.sleep(1000);
                    downLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        downLatch.await();
        log.info("end");
    }
}
