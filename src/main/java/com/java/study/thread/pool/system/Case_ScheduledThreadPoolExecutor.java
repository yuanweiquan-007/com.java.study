package com.java.study.thread.pool.system;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/24 2:43 下午
 */
@Slf4j
public class Case_ScheduledThreadPoolExecutor {

    public static void main(String[] args) throws Exception {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        log.info("start");

//        executeWithOutReturn(executor);
//        executeWithReturn(executor);
//        scheduleAtFixedRate(executor);
        scheduleWithFixedDelay(executor);

        TimeUnit.SECONDS.sleep(10);
        System.exit(0);
    }

    /**
     * 定时延迟、循环执行。循环执行的时间不包含任务的执行时间
     *
     * @param executor
     */
    private static void scheduleWithFixedDelay(ScheduledThreadPoolExecutor executor) {
        executor.scheduleWithFixedDelay(() -> {
            try {
                log.info("2");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 2, TimeUnit.SECONDS);
    }

    /**
     * 定时延迟、循环执行。循环执行的时间包含了任务的执行时间
     *
     * @param executor
     */
    private static void scheduleAtFixedRate(ScheduledThreadPoolExecutor executor) {
        executor.scheduleAtFixedRate(() -> {
            try {
                log.info("1");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1, 2, TimeUnit.SECONDS);
    }

    /**
     * 延迟执行有返回值
     *
     * @param executor
     * @throws Exception
     */
    private static void executeWithReturn(ScheduledThreadPoolExecutor executor) throws Exception {
        ScheduledFuture<String> stringScheduledFuture = executor.schedule(() -> {
            return "延迟1秒后的返回值";
        }, 1, TimeUnit.SECONDS);
        log.info(stringScheduledFuture.get());
    }

    /**
     * 定时延迟执行无返回值
     *
     * @param executor
     */
    private static void executeWithOutReturn(ScheduledThreadPoolExecutor executor) {
        executor.schedule(() -> {
            log.info("延迟1秒后执行");
        }, 1, TimeUnit.SECONDS);
    }

}
