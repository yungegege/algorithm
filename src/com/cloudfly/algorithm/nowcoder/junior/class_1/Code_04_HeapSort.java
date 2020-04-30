package com.cloudfly.algorithm.nowcoder.junior.class_1;

public class Code_04_HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 6, 3, 7, 9, 5, 21, 8, 21, 26, 12, 21, 423, 24, 574535, 3, 23523, 1215135, 135, 235, 426, 4, 443, 443, 3434};
        heapSort(arr);
        printArr(arr);
    }

    /**
     * 建个大根堆
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        printArr(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i);
        }
    }

    /**
     * 0-i已经建好了堆
     *
     * @param arr
     * @param i
     */
    public static void heapInsert(int[] arr, int i) {
        while (i > 0) {
            if (arr[i] > arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
            }
            i = (i - 1) / 2;
        }
    }


    /**
     * 0-len建好了堆
     *
     * @param arr
     * @param len
     */
    public static void heapify(int[] arr, int len) {
        int index = 0;
        while (2 * index + 1 < len) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int max = arr[left] > (right == len ? Integer.MIN_VALUE : arr[right]) ? left : right;
            if (arr[index] < arr[max]) {
                swap(arr, index, max);
            }
            index = max;
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
