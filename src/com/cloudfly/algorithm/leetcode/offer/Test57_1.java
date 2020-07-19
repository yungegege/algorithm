package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Test57_1 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{
                2, 7, 11, 15
        };
        int[] arr2 = new int[]{
                10, 26, 30, 31, 47, 60
        };
        System.out.println(Arrays.toString(twoSum(arr1, 9)));
        System.out.println(Arrays.toString(twoSum(arr2, 40)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{nums[left],nums[right]};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
