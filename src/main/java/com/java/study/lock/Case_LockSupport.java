package com.java.study.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/21 4:11 下午
 */
@Slf4j
public class Case_LockSupport {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            log.info("into thread");
            LockSupport.park();
            log.info("end park");
        }, "Thread");

        thread.start();

        TimeUnit.SECONDS.sleep(1);
        LockSupport.unpark(thread);
        TimeUnit.SECONDS.sleep(1);
        log.info("end");
    }
}
