package com.java.study.maps;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/25 3:13 下午
 */
@Slf4j
public class Case_HashMap {

    public static void main(String[] args) throws Exception {
//        case_hash();
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        log.info("{}", hashMap.get(1));
    }

    private static void case_hash() {
        System.out.println("a".hashCode());
        System.out.println(Integer.toBinaryString("a".hashCode()));

        log.info("10的hash值为：{}", hash(10));
        log.info("a的hash值为：{}", hash("a"));
    }

    public static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
