package com.java.study.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 10:51 上午
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool(2);
        for (int i = 1; i <= 5; i++) {
            int i1 = i;
            threadPool.execute(new ThreadPoolTask(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "Task" + i1));
        }

        TimeUnit.SECONDS.sleep(5);
        threadPool.execute(new ThreadPoolTask(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Main主任务"));

        System.exit(0);

    }

}
