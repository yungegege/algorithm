package com.cloudfly.algorithm.leetcode.dailyquestion;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Code_020_416 {

    public static void main(String[] args) {
        System.out.println(new Code_020_416().canPartition(new int[]{1, 5, 11, 9}));
    }

    /**
     * 思路：求数组总和，找子数组总和等于数组总和一半
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        // 求数组总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 剪枝
        if (sum % 2 == 1) {
            return false;
        }

        // 找总和为sum/2的子数组
        // 先来个递归版本,超时了
//        return digui(nums, 0, sum / 2);
        // 动态规划版本
        sum = sum/2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < dp.length - 1; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j]) {
                    dp[i + 1][j] = true;
                    if (j + nums[i] <= sum) {
                        dp[i + 1][j + nums[i]] = true;
                    }
                }
            }
        }
        return dp[nums.length][sum];
    }

    /**
     * 从curIndex开始,能否构成和为sum的子数组
     *
     * @param nums     数组
     * @param curIndex 当前位置
     * @param sum      总和
     * @return
     */
    private boolean digui(int[] nums, int curIndex, int sum) {
        if (curIndex >= nums.length || sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        return digui(nums, curIndex + 1, sum) || digui(nums, curIndex + 1, sum - nums[curIndex]);
    }
}
