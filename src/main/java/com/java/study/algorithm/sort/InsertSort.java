package com.java.study.algorithm.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 插入排序法
 */
public class InsertSort {

    public static final List<Integer> container = Arrays.asList(1, 3, 12, 4, 87, 5, 56, 24, 56, 6, 18, 16, 2, 45, 64, 36);

    public static void main(String[] args) throws Exception {

        for (int i = 1; i < container.size(); i++) {
            for (int j = i; j >= 0; j--) {
                if (container.get(j) < container.get(j - 1)) {
                    int midValue = container.get(j - 1);
                    container.set((j - 1), container.get(j));
                    container.set(j, midValue);
                } else {
                    break;
                }
            }
        }

        container.forEach(System.out::println);
    }

}
