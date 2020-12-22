package com.java.study.foreach;

import java.util.stream.IntStream;

/**
 * @author yuanweiquan
 */
public class ContinueForEach {

    public static void main(String[] args) {

        IntStream.range(1, 10).forEach(i -> {
            if (i % 2 == 0) {//过滤条件
                return;
            }
            System.out.println(i);
        });

    }

}
