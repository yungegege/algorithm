package com.cloudfly.algorithm.nowcoder.junior.class_1;

/**
 * 把一个数组中大于n的放左边，等于n的放中间，大于n的放右边
 */
public class Code_09_NetherlandsFlag {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 8, 3, 7, 9, 5, 21, 8, 21, 78, 3, 76, 1, 3, 8};
        netherlandsFlag(arr, 8);
        printArr(arr);
    }

    public static void netherlandsFlag(int[] arr, int num) {
        int l = -1;
        int r = arr.length;
        int i = 0;
        while (i < r) {
            if (arr[i] < num) {
                swap(arr, ++l, i++);
            } else if (arr[i] == num) {
                i++;
            } else {
                swap(arr, --r, i);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
