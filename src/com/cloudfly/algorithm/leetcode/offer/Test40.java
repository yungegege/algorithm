package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class Test40 {

    /**
     * if (k>arr.len/2) 可以建个小根堆,把最大的arr.len-k个数找出来，剩下的就是最小的k个数
     * if (k<=arr.len/2) 可以建个大根堆,把最小的k个数找出来即可
     */
    public static void main(String[] args) {
        int[] arr = new int[]{
                4, 5, 1, 6, 2, 7, 3, 8
        };
        System.out.println(Arrays.toString(getLeastNumbers(arr, 0)));
    }

    // 复习一下单调栈结构
    // 大根堆
    public static int[] getLeastNumbers(int[] arr, int k) {
        // 前k个数建个大根堆
        jiandui(arr, 0, k - 1);

        // 然后后面的数,大于堆顶元素，则跳过，小于堆顶元素，则放入堆顶，堆再调整下
        for (int i = k; i < arr.length; i++) {
            // 小于堆顶元素，交换
            if (arr[i] < arr[0]) {
                swap(arr, 0, i);
                xiayi(arr, 0, k - 1);
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        // 对res排序
        for (int i = res.length; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (res[j - 1] > res[j]) {
                    swap(res, j, j - 1);
                }
            }
        }
        return res;
    }

    private static void xiayi(int[] arr, int a, int end) {
        int left = 2 * a + 1;
        int right = 2 * a + 2;
        while (right <= end && arr[a] < Math.max(arr[left], arr[right]) || left <= end && arr[a] < arr[left]) {
            if (right > end || arr[left] > arr[right]) {
                swap(arr, a, left);
                a = 2 * a + 1;
            } else {
                swap(arr, a, right);
                a = 2 * a + 2;
            }
            left = 2 * a + 1;
            right = 2 * a + 2;
        }
    }

    // 在start-end(包含)范围内建力大根堆
    private static void jiandui(int[] arr, int start, int end) {
        for (int i = (end - 1) / 2; i >= start; i--) {
            xiayi(arr, i, end);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
