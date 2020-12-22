package com.java.study.foreach;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 9:59 下午
 */
@Slf4j
public class ParallelForEach {

    public static void main(String[] args) throws Exception {
        IntStream.rangeClosed(1, 100).parallel().forEach(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                log.info("{}", i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
