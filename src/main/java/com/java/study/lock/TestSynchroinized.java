package com.java.study.lock;

public class TestSynchroinized {

    private Integer i = 0;
    private volatile Integer j;

    public synchronized void add() {
        i++;
    }

    public void reduce() {
        synchronized (this) {
            i--;
        }
    }

}
