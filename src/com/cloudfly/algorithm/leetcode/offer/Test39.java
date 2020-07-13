package com.cloudfly.algorithm.leetcode.offer;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class Test39 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        };
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement2(arr));
        System.out.println(majorityElement3(arr));
    }

    public static int majorityElement3(int[] nums) {
        int num = 0;
        for (int count = 0, i = 0; i < nums.length; i++) {
            count = count == 0 ? (num = nums[i]) == nums[i] ? 1 : -1 : nums[i] == num ? count + 1 : count - 1;
        }
        return num;
    }

    /**
     * 摩尔投票法
     */
    public static int majorityElement2(int[] nums) {
        int num = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count++;
            } else {
                if (nums[i] == num) {
                    count++;
                    if (count >= nums.length - i) {
                        return num;
                    }
                } else {
                    count--;
                }
            }
        }
        return num;
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
}
