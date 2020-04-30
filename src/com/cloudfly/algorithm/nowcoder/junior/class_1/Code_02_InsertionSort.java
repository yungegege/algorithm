package com.cloudfly.algorithm.nowcoder.junior.class_1;

public class Code_02_InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{24,574535,3,23523,1215135,135,235,426,4,443,443,3434};
        InsertionSort(arr);
        printArr(arr);
    }

    public static void InsertionSort(int[] arr) {
        if (arr==null || arr.length<2){
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if (arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
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
