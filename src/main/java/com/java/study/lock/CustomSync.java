package com.java.study.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 自定义同步器，主要为了锁自定义锁服务
 * 暂时不考虑锁重入
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/16 8:55 下午
 */
public class CustomSync extends AbstractQueuedSynchronizer {

    /**
     * 尝试加锁
     *
     * @param arg
     * @return
     */
    @Override
    protected boolean tryAcquire(int arg) {
        //判断是否能占锁
        if (getState() == 0) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
        }
        return false;
    }

    /**
     * 尝试释放锁
     *
     * @param arg
     * @return
     */
    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    /**
     * 当前锁有么有被线程持有
     *
     * @return
     */
    @Override
    protected boolean isHeldExclusively() {
        return this.getState() != 0;
    }
}
