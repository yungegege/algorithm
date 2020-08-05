package com.cloudfly.algorithm.leetcode.program.array;

public class Test01 {

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int last0 = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (i - last0-1 > max) {
                    max = i - last0-1;
                }
                last0 = i;
            }
        }
        if (nums.length - last0 - 1 > max) {
            max = nums.length - last0 - 1;
        }
        return max;
    }
}
