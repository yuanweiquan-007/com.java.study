package com.java.study.thread.pool.system;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单个线程的线程池：
 * 控制任务串行，和单个线程的区别在于，如果任务执行出现了异常并未捕获，会重新创建一个新的线程来执行任务
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

        executorService.execute(() -> {
            log.info("main任务1执行完成");
            int i = 1 / 0;
        });

        //证实：线程中任务出现异常，会创建一个新的线程执行后续的任务
        executorService.execute(() -> {
            log.info("main任务2执行完成");
            int i = 1 / 0;
        });
    }
}
