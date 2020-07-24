package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Test51 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 3, 2, 3, 1
        };
        System.out.println(reversePairs(arr));
    }

    private static int count;

    /**
     * 以一个归并的变形,结束剑指offer刷题
     */
    public static int reversePairs(int[] nums) {
        count = 0;
        if (nums.length > 1) {
            digui(nums, 0, nums.length - 1);
        }
        return count;
    }

    private static void digui(int[] nums, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + (R - L) / 2;
        digui(nums, L, mid);
        digui(nums, mid + 1, R);

        // merge
        int[] temp = new int[R - L + 1];
        int i = 0;
        int l = L;
        int r = mid + 1;
        while (l <= mid && r <= R) {
            if (nums[l] <= nums[r]) {
                temp[i++] = nums[l++];
                count += (r - mid - 1);
            } else {
                temp[i++] = nums[r++];
            }
        }
        if (l <= mid) {
            while (l <= mid) {
                temp[i++] = nums[l++];
                count += (R - mid);
            }
        }
        if (r <= R) {
            while (r <= R) {
                temp[i++] = nums[r++];
            }
        }
        for (int j = 0; j < temp.length; j++) {
            nums[L + j] = temp[j];
        }
    }
}
