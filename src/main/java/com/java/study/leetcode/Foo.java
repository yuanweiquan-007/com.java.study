package com.java.study.leetcode;

public class Foo {

    public Foo() {

    }

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        Thread thread1 = new Thread(() -> System.out.println("1"));
        Thread thread2 = new Thread(() -> System.out.println("2"));
        Thread thread3 = new Thread(() -> System.out.println("3"));

        thread1.join();
        foo.first(thread1);
        thread2.join();
        foo.second(thread2);
        thread3.join();
        foo.third(thread3);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}