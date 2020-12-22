package com.java.study.thread.pool;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 线程资源对象
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 10:18 上午
 */
@Slf4j
@AllArgsConstructor
public class ThreadSource extends Thread {

    private String threadName;

    private ThreadPoolTask threadPoolTask;

    private ThreadPoolQueue threadPoolQueue;

    @Override
    @SneakyThrows
    public void run() {
        while (null != threadPoolTask || (threadPoolTask = threadPoolQueue.get()) != null) {
            Thread.currentThread().setName(threadName);
            threadPoolTask.getRunnable().run();
            TimeUnit.SECONDS.sleep(1);
            log.info("任务{}执行完成", threadPoolTask.getTaskName());
            this.threadPoolTask = null;
        }
    }
}
