package com.java.study.thread.pool.custom;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

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
        while (null != threadPoolTask || (threadPoolTask = threadPoolQueue.poll()) != null) {
            Thread.currentThread().setName(threadName);
            threadPoolTask.getRunnable().run();
            log.info("任务{}执行完成", threadPoolTask.getTaskName());
            this.threadPoolTask = null;
        }
    }
}
