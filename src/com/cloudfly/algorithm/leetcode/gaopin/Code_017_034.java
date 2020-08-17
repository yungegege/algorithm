package com.cloudfly.algorithm.leetcode.gaopin;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */
public class Code_017_034 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                2,3
        };
        System.out.println(Arrays.toString(new Code_017_034().searchRange(arr, 1)));
    }

    /**
     * 关键点：res[1] = nums[l] == target ? l : l - 1;
     * 因为l可能是target的位置 ，也可能是target的位置+1，所以要判断一下
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return new int[]{-1, -1};
        }
        res[0] = l;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        res[1] = nums[l] == target ? l : l - 1;
        return res;
    }
}
