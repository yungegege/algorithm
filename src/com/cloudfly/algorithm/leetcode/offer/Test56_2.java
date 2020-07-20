package com.cloudfly.algorithm.leetcode.offer;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。、
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class Test56_2 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{
                3, 4, 3, 3
        };
        int[] arr2 = new int[]{
                9, 1, 7, 9, 7, 9, 7
        };
        System.out.println(singleNumber(arr1));
        System.out.println(singleNumber(arr2));
    }

    public static int singleNumber(int[] nums) {
        int[] arr = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int wei = 0;
            while ((nums[i] >> wei) > 0 && wei < 32) {
                int n = nums[i] >> wei;
                arr[wei++] += (n & 1);
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 1) {
                res |= (1<<i);
            }
        }
        return res;
    }
}
