package com.java.study.thread.pool;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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

    private ReentrantLock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();

    private BlockingQueue<ThreadPoolTask> threadPoolTasks;

    public ThreadPoolQueue(int queueSize) {
        this.queueSize = queueSize;
        this.threadPoolTasks = new LinkedBlockingQueue<>(queueSize);
    }

    @SneakyThrows
    public void put(ThreadPoolTask threadPoolTask) {
        try {
            lock.lock();
            while (isFull()) {
                log.info("任务{}加入队列时，队列已满，等待", threadPoolTask.getTaskName());
                isFull.await();
            }

            threadPoolTasks.add(threadPoolTask);
            log.info("任务{}加入等待队列成功", threadPoolTask.getTaskName());
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    public void putWithRejectionPolicies(ThreadPoolTask threadPoolTask, ThreadPoolRejectionPolicies rejectionPolicies) {
        //拒绝策略为空，走默认的put逻辑
        if (null == rejectionPolicies) {
            put(threadPoolTask);
            return;
        }

        try {
            lock.lock();
            long waitTime = 2000;
            while (waitTime > 0 && isFull()) {
                waitTime = isFull.awaitNanos(waitTime);
                if (waitTime <= 0) {
                    log.info("任务{}加入队列时，队列已满，等待超时走拒绝策略", threadPoolTask.getTaskName());
                    rejectionPolicies.reject(threadPoolTask);
                    return;
                }
            }

            threadPoolTasks.add(threadPoolTask);
            log.info("任务{}加入等待队列成功", threadPoolTask.getTaskName());
            isEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    public ThreadPoolTask poll() {
        try {
            lock.lock();
            while (isEmpty()) {
                log.info("拿任务时任务队列为空，等待任务的加入……");
                isEmpty.await();
            }

            ThreadPoolTask threadPoolTask = threadPoolTasks.poll();
            log.info("从队列中拿到任务{}", threadPoolTask.getTaskName());
            isFull.signal();
            return threadPoolTask;
        } finally {
            lock.unlock();
        }
    }

    private Boolean isFull() {
        return threadPoolTasks.size() >= queueSize;
    }

    private Boolean isEmpty() {
        return threadPoolTasks.isEmpty();
    }

}
