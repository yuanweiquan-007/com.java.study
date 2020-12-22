package com.java.study.thread;

public class NewThread extends Thread {

     private static final class MyThread extends Thread {
          @Override
          public void run() {
               try {
                    Thread.sleep(2000);
                    System.out.println("继承Thread的线程");
               } catch (Exception ex) {
                    ex.printStackTrace();
               }
          }
     }

     private static final class MyRunnable implements Runnable {
          @Override
          public void run() {
               try {
                    Thread.sleep(1000);
                    System.out.println("实现Runnable的线程");
               } catch (Exception ex) {
                    ex.printStackTrace();
               }
          }
     }

     public static void main(String[] args) {
          MyThread myThread = new MyThread();
          myThread.start();

          new Thread(new MyRunnable()).start();
          System.out.println("end");
     }

}
