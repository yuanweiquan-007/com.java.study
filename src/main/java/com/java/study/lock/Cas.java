package com.java.study.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Cas {

    int i = 0;
    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void increatse() {
        i++;
    }

    public void safeIncreatse() {
        for (; ; ) {
            int i = atomicInteger.get();
            //只能调用封装好的compareAndSet方法，因为底层调用了native方法
            if (atomicInteger.compareAndSet(i, ++i)) {
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Cas cas = new Cas();
        IntStream.rangeClosed(1, 100).parallel().forEach(i -> cas.increatse());
        System.out.println(cas.i);

        IntStream.rangeClosed(1, 100).parallel().forEach(i -> cas.safeIncreatse());
        System.out.println(cas.atomicInteger.get());
    }

}
