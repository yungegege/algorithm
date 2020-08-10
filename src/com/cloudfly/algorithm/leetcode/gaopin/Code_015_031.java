package com.cloudfly.algorithm.leetcode.gaopin;

import java.util.Arrays;

public class Code_015_031 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int index = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i;
                break;
            }
        }
        if (index == nums.length - 1) {
            swap(nums, index, index - 1);
        } else if (index == 0) {
            for (int i = 0; i < (nums.length + 1) / 2; i++) {
                swap(nums, i, nums.length - 1 - i);
            }
        } else {
            int num = index;
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index - 1]) {
                    num = i;
                    break;
                }
            }
            swap(nums, index - 1, num);
            for (int i = 0; i <= (nums.length-1-index) / 2; i++) {
                swap(nums, index+i , nums.length-1-i);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
