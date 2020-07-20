package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Test56_1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{
                4, 1, 4, 6
        };
        int[] arr2 = new int[]{
                1, 2, 10, 4, 1, 4, 3, 3
        };
        // 1 6
        System.out.println(Arrays.toString(singleNumbers(arr1)));
        // 2 10
        System.out.println(Arrays.toString(singleNumbers(arr2)));

    }

    public static int[] singleNumbers(int[] nums) {
        if (nums.length <= 2) {
            return nums;
        }
        int[] res = new int[2];
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        int count = 0;
        while ((n & 1) != 1) {
            n = n >> 1;
            count += 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >> count&1) == 1){
                res[0]^=nums[i];
            }else {
                res[1]^=nums[i];
            }
        }
        return res;
    }
}
