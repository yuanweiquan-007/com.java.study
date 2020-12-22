package com.java.study.suanfa.sort;

import java.util.Arrays;
import java.util.List;

/**
 * 选择排序法
 */
public class SelectSort {

    public static final List<Integer> container = Arrays.asList(1, 3, 12, 4, 87, 5, 56, 24, 56, 6, 18, 16, 2, 45, 64, 36);

    public static void main(String[] args) throws Exception {
        sort();
        container.forEach(System.out::println);
    }

    public static void sort() {
        for (int i = 0; i < container.size(); i++) {
            int minIndex = i;
            int minValue = container.get(i);
            for (int j = i; j < container.size(); j++) {
                if (minValue > container.get(j)) {
                    minIndex = j;
                    minValue = container.get(j);
                }
            }
            exch(i, minIndex, minValue);
        }
    }

    /**
     * 交换
     *
     * @param i        需要交换的数组下标
     * @param minIndex 最小值下标
     * @param minValue 最小值
     */
    private static void exch(int i, int minIndex, int minValue) {
        int midValue = container.get(i);
        container.set(i, minValue);
        container.set(minIndex, midValue);
    }


}
