package com.java.study.thread.pool.system;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 缓存线程池的使用：适合任务执行时间很短的场景。如果执行时间很长会无限制创建线程。
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/23 10:14 上午
 */
@Slf4j
public class Case_CachedThreadPool {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            int number = i;
            executorService.execute(() -> {
                try {
                    log.info("任务{}执行完成，线程池中总线程数:{}", number, executorService.getPoolSize());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            Thread.sleep(100);//演示调用间隔
        }
    }

}
