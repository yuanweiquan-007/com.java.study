package com.java.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * 用来限制对资访问的线程的上限，而不是限制资源的上限
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/20 10:52 上午
 */
@Slf4j
public class Case_Semaphore {
    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 16; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(500);
                    log.info("get lock and do something");
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, "Thread" + i).start();
        }
    }
}
