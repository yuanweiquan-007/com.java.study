package com.java.study.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程顺序执行
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/15 4:32 下午
 */
@Slf4j
public class ExecuteByOrder {

    private volatile Integer version = 1;
    private Object object = new Object();

    public void methodA() throws Exception {
        synchronized (object) {
            while (version != 1) {
                object.wait();
            }
            log.info("A");
            version++;
            object.notifyAll();
        }
    }

    public void methodB() throws Exception {
        synchronized (object) {
            while (version != 2) {
                object.wait();
            }
            log.info("B");
            version++;
            object.notifyAll();
        }
    }

    public void methoC() throws Exception {
        synchronized (object) {
            while (version != 3) {
                object.wait();
            }
            log.info("C");
            version++;
            object.notifyAll();
        }
    }

    public void executeByOrder() {
        Thread threadA = new Thread(() -> {
            try {
                methodA();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ThreadA");

        Thread threadB = new Thread(() -> {
            try {
                methodB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ThreadB");

        Thread threadC = new Thread(() -> {
            try {
                methoC();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "ThreadC");

        threadB.start();
        threadC.start();
        threadA.start();
    }

    public static void main(String[] args) throws Exception {
        ExecuteByOrder execute = new ExecuteByOrder();
        execute.executeByOrder();
    }

}
