package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Test21 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(exchange(arr)));
    }


    public static int[] exchange(int[] nums) {
        int L = 0;
        int R = nums.length;
        while (L<R){
            if (nums[L]%2==0){
                // 偶数,R--,然后和R交换
                swap(nums,L,--R);
            }else {
                // 奇数
                L++;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
