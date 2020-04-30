package com.cloudfly.algorithm.nowcoder.junior.class_1;

public class Code_06_MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 6, 3, 7, 9, 5, 21, 8, 21, 26, 12, 21, 423, 24, 574535, 3, 23523, 1215135, 135, 235, 426, 4, 443, 443, 3434};
        mergeSort(arr);
        printArr(arr);
    }

    private static void mergeSort(int[] arr) {

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
