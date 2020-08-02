package com.cloudfly.algorithm.leetcode.on;

/**
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，
 * 如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 */
public class Code_01 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(findMagicIndex(arr));
    }

    /**
     * 1 2 5 5 5 5
     * 1 6 6 6 6 6
     */
    public static int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                return i;
            }
            i = Math.max(i + 1, nums[i]);
        }
        return -1;
    }
}
