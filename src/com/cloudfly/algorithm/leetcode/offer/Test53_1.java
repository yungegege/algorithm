package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class Test53_1 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                6, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 9
        };
        System.out.println(search(arr, 7));
        System.out.println(search(arr, 8));
        System.out.println(search(arr, 9));

    }

    /**
     * 二分查找第一个比他小的,位置是a,第一个比他大的,位置是b,返回b-a-1
     */
    public static int search(int[] arr, int target) {
        if (arr.length == 0) {
            return 0;
        }
        int i = findSmall(arr, target);
        if (i == -1) {
            return 0;
        }
        int j = findBig(arr, target);
        return j - i + 1;
    }

    /**
     * 找target的最大索引
     */
    private static int findBig(int[] arr, int target) {
        if (arr[arr.length - 1] == target) {
            return arr.length - 1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (mid + 1 < arr.length && arr[mid] == target && arr[mid + 1] > target) {
                return mid;
            }
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;

        }
        return -1;
    }

    private static int findSmall(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid - 1 >= 0 && arr[mid] == target && arr[mid - 1] < target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分找到后，左右寻找
     */
    public static int search2(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return 0;
        }
        int count = 1;
        int i = index - 1;
        while (i >= 0 && nums[i] == nums[index]) {
            i--;
            count++;
        }
        i = index + 1;
        while (i < nums.length && nums[i] == nums[index]) {
            i++;
            count++;
        }
        return count;
    }
}
