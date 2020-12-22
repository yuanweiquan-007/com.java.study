package com.java.study.suanfa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 二分查找算法
 */
public class BinarySearch {

    public static final List<Integer> container = Arrays.asList(1, 3, 12, 4, 87, 5, 56, 24, 56, 6, 18, 16, 2, 45, 64, 36);

    public static void main(String[] args) throws Exception {
        int searchValue = 24;
        int index = search(searchValue);
        System.out.println(index);
    }


    /**
     * 查找指定元素的下标，如果不存在返回-1
     *
     * @param search 需要查找的值
     * @return
     */
    private static int search(int search) {
        container.sort(Comparator.comparingInt(a -> a));
        int begin = 0;
        int end = container.size() - 1;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (search > container.get(middle)) {
                begin = middle + 1;
            } else if (search < container.get(middle)) {
                end = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
