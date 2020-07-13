package com.cloudfly.algorithm.leetcode.offer;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 */
public class Test42 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        // 6
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr) {
        int pre = arr[0];
        int max = pre;
        for (int i = 1; i < arr.length; i++) {
            if (pre < 0) {
                pre = arr[i];
            } else {
                pre = pre + arr[i];
            }
            if (pre > max) {
                max = pre;
            }
        }
        return max;
    }
}
