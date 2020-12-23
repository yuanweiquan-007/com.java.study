package com.java.study.thread.pool.system;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单个线程的线程池
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/23 10:06 上午
 */
@Slf4j
public class Case_SingleThreadExecutor {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 5; i++) {
            int num = i;
            executorService.execute(() -> {
                try {
                    log.info("任务{}执行完成", num);
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

}
