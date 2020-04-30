package com.cloudfly.algorithm.nowcoder.junior.class_1;

public class Code_03_SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2,574535,3,23523,1215135,135,235,426,4,443,443,3434};
        selectionSort(arr);
        printArr(arr);
    }

    public static void selectionSort(int[] arr) {
        if (arr==null || arr.length<2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
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
