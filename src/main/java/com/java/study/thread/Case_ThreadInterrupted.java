package com.java.study.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 线程打断
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/18 10:25 上午
 */
@Slf4j
public class Case_ThreadInterrupted {

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                log.info("线程被打断", e);
//                log.info("被打断后继续执行");
//            }

//            LockSupport.park();
//            log.info("被打断后继续执行");

            synchronized (Thread.currentThread()) {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    log.info("线程被打断", e);
                    log.info("被打断后继续执行");
                }
            }

            //非上述三种情况
//            int i = 0;
//            while (true) {
//                i++;
//            }

        }, "Thread1");

        thread1.start();
        thread1.interrupt();

        TimeUnit.SECONDS.sleep(2);

        log.info("线程1的interrupted状态：{}", thread1.isInterrupted());
        log.info("end");
        System.exit(0);
    }
}
