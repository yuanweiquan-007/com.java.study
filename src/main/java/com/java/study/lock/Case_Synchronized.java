package com.java.study.lock;

public class Case_Synchronized {

    private Object objectA = new Object();

    public static void main(String[] args) throws Exception {
        Case_Synchronized sync = new Case_Synchronized();
        new Thread(() -> sync.syncStaticMethod()).start();
//        new Thread(() -> sync.method()).start();
        new Thread(() -> sync.syncCode()).start();
        new Thread(() -> sync.syncObject()).start();
        new Thread(() -> sync.syncClassObject()).start();

        Thread.sleep(5000);
    }

    public synchronized void method() {
        try {
//            Thread.sleep(2000);
            System.out.println("method1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void syncObject() {
        synchronized (objectA) {
            System.out.println("syncObject");
        }
    }

    public void syncCode() {
        synchronized (this) {
            System.out.println("syncCode");
        }
    }

    public void syncClassObject() {
        synchronized (Case_Synchronized.class) {
            System.out.println("syncClassObject");
        }
    }

    public static synchronized void syncStaticMethod() {
        try {
            Thread.sleep(2000);
            System.out.println("syncStaticMethod");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
