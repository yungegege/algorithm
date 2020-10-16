package com.cloudfly.algorithm.nowcoder.junior.class_1;

/**
 * 快排
 */
public class Code_05_QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 6, 3, 7, 9, 5, 21, 8, 21, 78, 3, 76, 1, 3, 34, 235, 3, 352, 243, 35, 4754, 3, 26, 12, 21, 423, 24, 574535, 3, 23523, 1215135, 135, 235, 426, 4, 443, 443, 3434,6};
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int[] partition = partition(arr, L, R);
            quickSort(arr, L, partition[0] - 1);
            quickSort(arr, partition[1] + 1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        L = L - 1;
        int more = R;
        int i = L + 1;
        while (i < more) {
            if (arr[i] < arr[R]) {
                swap(arr, ++L, i++);
            } else if (arr[i] > arr[R]) {
                swap(arr, --more, i);
            } else {
                i++;
            }
        }
        swap(arr, i, R);
        return new int[]{L+1 , more };
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
