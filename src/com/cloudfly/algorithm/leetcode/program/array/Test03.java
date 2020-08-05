package com.cloudfly.algorithm.leetcode.program.array;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-29 17:02
 */
public class Test03 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2147483648, 2};
        System.out.println(thirdMax(arr));
    }

    public static int thirdMax(int[] nums) {
        // 最大
        int a = nums[0];
        // 第二大
        int b = Integer.MIN_VALUE;
        // 第三大
        int c = Integer.MIN_VALUE;
        int m = nums[0];
        int n = nums[0];
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            // 这段就是配合flag看是否有三个不同的数的
            if (n == m) {
                if (nums[i] != m) {
                    n = nums[i];
                }
            } else if (nums[i] != n && nums[i] != m) {
                flag = true;
            }
            if (nums[i] == a || nums[i] == b || nums[i] == c) {
                continue;
            }
            if (nums[i] > a) {
                c = b;
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                c = b;
                b = nums[i];
            } else if (nums[i] > c) {
                c = nums[i];
            }
        }
        return flag ? c : a;
    }
}
