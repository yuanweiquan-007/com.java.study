package com.java.study.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/24 2:33 下午
 */
public class Case_StopThread {

    private static Boolean stopFlag = false;

    public static void main(String[] args) throws Exception {

        new Thread(() -> {
            int i = 0;
            while (!stopFlag) {
                i++;
//                System.out.println(i);
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        stopFlag = true;
    }

}
