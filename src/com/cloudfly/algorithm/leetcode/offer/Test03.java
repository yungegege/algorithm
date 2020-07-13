package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-07 10:55
 */
public class Test03 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 6, 2, 5, 3};
        System.out.println(findRepeatNumber(arr));

        int[] arr2 = new int[]{2, 3, 1, 6, 2, 5, 3};
        System.out.println(findRepeatNumber2(arr2));

        int[] arr3 = new int[]{2, 3, 1, 6, 2, 5, 3};
        System.out.println(findRepeatNumber3(arr3));
    }

    /**
     * nums长度为n,范围为0 ~ n-1
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) {
                return i;
            }
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            // 如果当前的数 nums[i] 没有在下标为 i 的位置上，就把它交换到下标 i 上
            // 交换过来的数还得做相同的操作，因此这里使用 while
            // 可以在此处将数组输出打印，观察程序运行流程
            System.out.println("-" + Arrays.toString(nums));

            while (nums[i] != i) {

                if (nums[i] == nums[nums[i]]) {
                    // 如果下标为 nums[i] 的数值 nums[nums[i]] 它们二者相等
                    // 正好找到了重复的元素，将它返回
                    return nums[i];
                }
                swap(nums, i, nums[i]);
                System.out.println("--" + Arrays.toString(nums));
            }
        }
        throw new IllegalArgumentException("数组中不存在重复数字！");
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] % nums.length;
            nums[index] += nums.length;
            System.out.println(Arrays.toString(nums));
            if (nums[index] >= 2 * nums.length) {
                return index;
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= 2 * nums.length) {
//                return i;
//            }
//        }
        return -1;
    }
}
