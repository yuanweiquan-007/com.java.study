package com.java.study.leetcode;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/12 3:11 下午
 */
public class WiggleMaxLength {

    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{3, 3, 3, 2, 5};
        System.out.println(new WiggleMaxLength().wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int flag = 0;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;
            if (nums[i] == nums[j]) {
                continue;
            }
            int newFlag = flag(nums[i], nums[j]);
            if (flag == 0 || (flag == -newFlag)) {
                count++;
                flag = newFlag;
            }
        }
        return count;
    }

    private int flag(int x, int y) {
        if (x > y) {
            return 1;
        } else {
            return -1;
        }
    }

}
