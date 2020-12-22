package com.java.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/20 11:45 上午
 */
@Slf4j
public class Case_CyclicBarrier {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(() -> {
            try {
                cyclicBarrier.await();
                log.info("开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "Thread1").start();

        new Thread(() -> {
            try {
                cyclicBarrier.await();
                log.info("开始执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "Thread2").start();

        TimeUnit.SECONDS.sleep(2);
        cyclicBarrier.await();
        TimeUnit.SECONDS.sleep(1);
        log.info("end");
    }
}
