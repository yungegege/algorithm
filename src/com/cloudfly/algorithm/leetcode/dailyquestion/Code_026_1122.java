package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.Arrays;

public class Code_026_1122 {

    public static void main(String[] args) {
        int[] arr = new Code_026_1122().relativeSortArray(
                new int[]{
                        2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19
                },
                new int[]{
                        2, 1, 4, 3, 9, 6
                }
        );
        System.out.println(Arrays.toString(arr));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            arr[arr1[i]]++;
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr[arr2[i]]; j++) {
                arr1[index++] = arr2[i];
            }
            arr[arr2[i]] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                arr1[index++] = i;
            }
        }
        return arr1;
    }
}
