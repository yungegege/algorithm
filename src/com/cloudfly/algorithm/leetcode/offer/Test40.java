package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Test40 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                4, 5, 1, 6, 2, 7, 3, 8
        };
        System.out.println(Arrays.toString(getLeastNumbers(arr, 4)));
    }

    // 复习一下单调栈结构
    // 大根堆
    public static int[] getLeastNumbers(int[] arr, int k) {
        // 前k个数建个大根堆

        // 然后后面的数,大于堆顶元素，则跳过，小于堆顶元素，则放入堆顶，堆再调整下


        return null;
    }
}
