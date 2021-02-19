package com.java.study;

import java.util.stream.IntStream;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2021/1/20 10:20 下午
 */
public class Test {

    public static void main(String[] args) throws Exception {

        IntStream.range(1,20).forEach(i -> {
            if(i == 5) {
                return;
            }
            System.out.println(i);
        });

    }

}
