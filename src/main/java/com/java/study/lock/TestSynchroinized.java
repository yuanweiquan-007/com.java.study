package com.java.study.lock;

public class TestSynchroinized {

    private Integer i = 0;

    public synchronized void add() {
        i++;
    }

    public void reduce() {
        synchronized (this) {
            i--;
        }
    }

}
