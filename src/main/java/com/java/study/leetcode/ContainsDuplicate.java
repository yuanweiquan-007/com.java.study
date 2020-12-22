package com.java.study.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/13 10:40 上午
 */
public class ContainsDuplicate {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            if (sets.contains(num)) {
                return true;
            }
            sets.add(num);
        }
        return false;
    }

}
