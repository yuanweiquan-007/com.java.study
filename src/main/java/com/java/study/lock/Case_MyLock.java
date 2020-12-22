package com.java.study.lock;

public class Case_MyLock {

    private Integer num = 0;

    private MyLock myLock = new MyLock();

    public void addSum() {
        myLock.lock();
        this.num++;
        myLock.unLock();
    }

    public static void main(String[] args) throws Exception {
        Case_MyLock caseMyLock = new Case_MyLock();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                caseMyLock.addSum();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                caseMyLock.addSum();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(caseMyLock.num);
    }

}
