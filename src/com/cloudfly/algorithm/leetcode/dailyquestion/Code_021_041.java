package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class Code_021_041 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,1
        };
        int a = new Code_021_041().firstMissingPositive2(arr);
        System.out.println(a);
        System.out.println(Arrays.toString(arr));
    }

    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] - 1 != i ){
                if(nums[nums[i] - 1]==nums[i]){
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]-1!=i){
                return i+1;
            }
        }
        return nums.length+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public int firstMissingPositive(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= 0) {
//                nums[i] = nums.length + 1;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int num = Math.abs(nums[i]);
//            if (num <= nums.length) {
//                nums[num - 1] = -Math.abs(nums[num - 1]);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                return i + 1;
//            }
//        }
//        return nums.length + 1;
//    }
}
