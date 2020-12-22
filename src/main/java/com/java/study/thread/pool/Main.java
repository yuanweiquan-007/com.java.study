package com.java.study.thread.pool;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 10:51 上午
 */
@Slf4j
public class Main {

    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool(2);
        for (int i = 1; i <= 3; i++) {
            int i1 = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task{} 被执行", i1);
                }
            });
        }
    }

}
