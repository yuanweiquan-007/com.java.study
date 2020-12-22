package com.java.study.thread.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

/**
 * 线程池队列
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 11:51 上午
 */
@Slf4j
public class ThreadPoolQueue {
    //队列容量
    private Integer queueSize;
    //队列是否已满条件
    private Condition isFull;
    //队列是否为空条件
    private Condition isEmpty;

    private BlockingQueue<ThreadPoolTask> threadPoolTasks = null;

    public ThreadPoolQueue(int queueSize, Condition isFull, Condition isEmpty) {
        this.isFull = isFull;
        this.isEmpty = isEmpty;
        this.queueSize = queueSize;
        this.threadPoolTasks = new LinkedBlockingQueue<ThreadPoolTask>(queueSize);
    }

    @SneakyThrows
    public void put(ThreadPoolTask threadPoolTask) {
        while (isFull()) {
            log.info("任务{}加入队列时，队列已满，等待", threadPoolTask.getTaskName());
            isFull.await();
        }
        threadPoolTasks.add(threadPoolTask);
        log.info("任务{}加入等待队列成功", threadPoolTask.getTaskName());
        isEmpty.signal();
    }

    @SneakyThrows
    public ThreadPoolTask get() {
        while (isEmpty()) {
            log.info("任务队列为空，等待任务的加入");
            isEmpty.await();
        }
        ThreadPoolTask threadPoolTask = threadPoolTasks.poll();
        log.info("从队列中拿到任务{}", threadPoolTask.getTaskName());
        isFull.signal();
        return threadPoolTask;
    }

    private Boolean isFull() {
        return threadPoolTasks.size() >= queueSize;
    }

    private Boolean isEmpty() {
        return threadPoolTasks.isEmpty();
    }

}
