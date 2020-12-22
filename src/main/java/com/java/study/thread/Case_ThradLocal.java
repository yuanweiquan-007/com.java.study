package com.java.study.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/21 10:14 上午
 */
@Slf4j
public class Case_ThradLocal {

    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {
        executor.execute(() -> {
            threadLocal.set("MyName");
            log.info("set my name success");
        });

        executor.execute(() -> {
            log.info(threadLocal.get());
        });
    }

}
