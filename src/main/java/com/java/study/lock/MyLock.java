package com.java.study.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class MyLock {

    private volatile int status = 0;
    private static Long offsetAdderss = 0L;

    private static Unsafe unsafe = getUnsafe();

    static {
        try {
            Field field = MyLock.class.getDeclaredField("status");
            offsetAdderss = getUnsafe().objectFieldOffset(field);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void lock() {
        //自旋
        while (!compareAndSet(0, 1)) {
        }
    }

    public void unLock() {
        this.status = 0;
    }

    /**
     * cpu级别的
     *
     * @param exceptValue
     * @param updateValue
     * @return
     */
    private Boolean compareAndSet(Integer exceptValue, Integer updateValue) {
        return getUnsafe().compareAndSwapInt(this, this.offsetAdderss, exceptValue, updateValue);
    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
