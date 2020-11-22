package com.cloudfly.algorithm.leetcode.dailyquestion;

public class Code_029_1658 {
    public static void main(String[] args) {
        System.out.println(new Code_029_1658().minOperations(new int[]{
                1,1
        }, 3));
    }

    public int minOperations(int[] nums, int x) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = -x;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        while (j < nums.length) {
            curSum += nums[j++];
            while (curSum > sum && i < j) {
                curSum -= nums[i++];
            }
            if (curSum == sum) {
                max = Math.max(max, j - i);
            }
        }
        return max == Integer.MIN_VALUE ? -1 : nums.length - max;
    }


    // 暴力，超时
    public int minOperations2(int[] nums, int x) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] arr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
        //  问题转换为求有无 和为总和减去x的子数组
        int sum = arr[arr.length - 1] - x;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] - arr[i] == sum) {
                    max = Math.max(max, j - i);
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : nums.length - max;
    }
}
