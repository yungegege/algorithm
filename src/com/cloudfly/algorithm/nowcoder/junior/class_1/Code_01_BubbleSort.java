package com.cloudfly.algorithm.nowcoder.junior.class_1;

public class Code_01_BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 6, 3, 7, 9, 5, 21, 8, 21, 78, 21, 423, 24, 574535, 3, 23523, 1215135, 135, 235, 426, 4, 443, 443, 3434};
        bubbleSort(arr);
        printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        if (arr==null || arr.length<2){
            return;
        }
        for (int i = arr.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (arr[j-1] > arr[j]) {
                    swap(arr, j-1, j);
                }
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
    }

}
