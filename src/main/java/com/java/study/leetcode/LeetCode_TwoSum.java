package com.java.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class LeetCode_TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        for (int i : twoSum(arr, 9)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (map.containsKey(value)) {
                return new int[]{map.get(value), i};
            } else {
                map.put(target - value, i);
            }
        }
        return null;
    }

}
