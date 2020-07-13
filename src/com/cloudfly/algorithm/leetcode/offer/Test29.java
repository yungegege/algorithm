package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Test29 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        System.out.println(Arrays.toString(spiralOrder(arr)));
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }
        int l = 0;  // 左
        int r = matrix[0].length - 1;  // 右
        int t = 0;  // 上
        int b = matrix.length - 1; // 下
        int[] arr = new int[(r + 1) * (b + 1)];
        int index = 0;
        while (l <= r && t <= b) {
            for (int i = l; i < r; i++) {
                if (index == arr.length) {
                    break;
                }
                arr[index++] = matrix[t][i];
            }
            for (int i = t; i < b; i++) {
                if (index == arr.length) {
                    break;
                }
                arr[index++] = matrix[i][r];
            }


            for (int i = r; i > l; i--) {
                if (index == arr.length) {
                    break;
                }
                arr[index++] = matrix[b][i];
            }

            for (int i = b; i > t; i--) {
                if (index == arr.length) {
                    break;
                }
                arr[index++] = matrix[i][l];
            }
            if (l==r && t==b){
                arr[index] = matrix[l][t];
            }
            l++;
            r--;
            t++;
            b--;

        }
        return arr;
    }
}
