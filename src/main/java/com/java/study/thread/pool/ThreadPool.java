package com.java.study.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 10:14 上午
 */
@Slf4j
public class ThreadPool {

    /**
     * 核心线程数
     */
    private Integer coreSize;

    /**
     * 等待任务队列大小
     */
    private Integer queueSize = 2;

    /**
     * 线程资源数
     */
    private HashSet<ThreadSource> threadSources = new HashSet<>();

    private ReentrantLock lock = new ReentrantLock();

    /**
     * 拒绝策略
     */
    private ThreadPoolRejectionPolicies rejectionPolicies;

    /**
     * 任务队列
     */
    private ThreadPoolQueue threadPoolQueue = new ThreadPoolQueue(queueSize);

    public ThreadPool(Integer coreSize) {
        this.coreSize = coreSize;
    }

    public ThreadPool(Integer coreSize, ThreadPoolRejectionPolicies rejectionPolicies) {
        this.coreSize = coreSize;
        this.rejectionPolicies = rejectionPolicies;
    }

    public void execute(ThreadPoolTask threadPoolTask) {
        try {
            lock.lock();
            if (!isFull()) {
                String threadName = String.format("线程%s", (threadSources.size() + 1));
                ThreadSource threadMeta = new ThreadSource(threadName, threadPoolTask, threadPoolQueue);
                threadSources.add(threadMeta);
                threadMeta.start();
                return;
            }
            //核心线程数满了 加入队列
            threadPoolQueue.putWithRejectionPolicies(threadPoolTask, rejectionPolicies);
        } finally {
            lock.unlock();
        }
    }

    private Boolean isFull() {
        return this.threadSources.size() >= coreSize;
    }

}
