package com.cloudfly.algorithm.leetcode.oneweek.race216th;

/**
 * 给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
 * 比方说，如果 nums = [6,1,7,4,1] ，那么：
 * 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
 * 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
 * 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
 * 如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
 * 请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
 */
public class Test_3 {

    public static void main(String[] args) {
        System.out.println(new Test_3().waysToMakeFair(new int[]{
                2, 1, 6, 4
        }));
    }

    /**
     * 输入：nums = [2,1,6,4]
     * 输出：1
     * 解释：
     * 删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
     * 删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
     * 删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
     * 删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
     * 只有一种让剩余数组成为平衡数组的方案。
     */
    public int waysToMakeFair(int[] nums) {
        // 左边奇数和
        int[] left1 = new int[nums.length];
        // 左边偶数和
        int[] left2 = new int[nums.length];
        // 右边奇数和
        int[] right1 = new int[nums.length];
        // 右边偶数和
        int[] right2 = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            left1[i] = left1[i - 1];
            left2[i] = left2[i - 1];
            if (i % 2 == 1) {
                left1[i] += nums[i - 1];
            } else {
                left2[i] += nums[i - 1];
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right1[i] = right1[i + 1];
            right2[i] = right2[i + 1];
            if (i % 2 == 1) {
                right1[i] += nums[i + 1];
            } else {
                right2[i] += nums[i + 1];
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left1[i] + right2[i] == left2[i] + right1[i]) {
                res++;
            }
        }
        return res;
    }
}
