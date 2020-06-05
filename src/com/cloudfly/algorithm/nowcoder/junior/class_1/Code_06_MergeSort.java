package com.cloudfly.algorithm.nowcoder.junior.class_1;

/**
 * 归并排序
 */
public class Code_06_MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 2, 6, 3, 7, 9, 5, 21, 8, 21, 26, 12, 21, 423, 24, 574535, 3, 23523, 1215135, 135, 235, 426, 4, 443, 443, 3434};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        // 终止条件
        if (L == R) {
            return;
        }
        int mid = (L+R)/2;
        // 对左边一半和右一半分别排序
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);

        // 合并
        int[] temp = new int[R - L + 1];
        int l = L;
        int r = mid + 1;
        int i = 0;
        while (l <= mid && r <= R) {
            if (arr[l] < arr[r]) {
                temp[i++] = arr[l++];
            } else {
                temp[i++] = arr[r++];
            }
        }
        if (l == mid+1) {
            while (r <= R) {
                temp[i++] = arr[r++];
            }
        } else if (r==R+1){
            while (l <= mid) {
                temp[i++] = arr[l++];
            }
        }

        for (int j = 0; j < temp.length; j++) {
            arr[j + L] = temp[j];
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
