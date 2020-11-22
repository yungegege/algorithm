package com.cloudfly.algorithm.leetcode.dailyquestion;

public class Code_034_494 {

    public static void main(String[] args) {

    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int target = (sum-S)/2;
        int[] dp = new int[target+1];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return 0;
    }
}
