package com.cloudfly.algorithm.leetcode.gaopin;

import java.util.Arrays;

// 来个简单易懂的思路：
//一、先找到最大值的位置index，
//这好像是个easy题，记不清了
//二、然后判断
//1 .target大于nums[0] 就从0到index二分查找，
//2. target小于nums[0] 从index+1到nums.length-1二分查找
//3.等于，直接返回0
//至于二分查找代码懒得写了
public class Code_016_033 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 3
        };
        System.out.println(new Code_016_033().search(arr, 3));
    }


    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        // 找最大值
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[l]) {
                r = mid;
            } else if (nums[mid] > nums[l]) {
                l = mid;
            } else {
                if (nums[l + 1] > nums[l]) {
                    l++;
                }
                break;
            }
        }
        int res = -1;
        // l+1到nums.length-1 二分查找
        if (target > nums[0]) {
            res = binarySearch(nums, 0, l + 1, target);
        } else if (target < nums[0]) {
            res = binarySearch(nums, l + 1, nums.length, target);
        } else {
            res = 0;
        }
        return res;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        if (r > nums.length) {
            return -1;
        }
        int res = Arrays.binarySearch(nums, l, r, target);
        return res > 0 ? res : -1;
    }
}
