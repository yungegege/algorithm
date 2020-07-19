package com.cloudfly.algorithm.leetcode.offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Test53_2 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{
                0, 1, 2, 3
        };
        int[] arr2 = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 9
        };

        System.out.println(missingNumber(arr1));
        System.out.println(missingNumber(arr2));
    }

    /**
     * 二分
     */
    public static int missingNumber(int[] arr) {

        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
//            if (mid > 0 && arr[mid] - arr[mid - 1] > 1) {
//                return arr[mid] - 1;
//            }
//            if (mid + 1 < arr.length && arr[mid + 1] - arr[mid] > 1) {
//                return arr[mid] + 1;
//            }
            if (mid >= arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /**
     * 异或运算
     */
    public static int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
