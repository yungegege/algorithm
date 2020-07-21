package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class Test45 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                3, 30, 34, 5, 9
        };
        System.out.println(minNumber(arr));
    }

    public static String minNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
