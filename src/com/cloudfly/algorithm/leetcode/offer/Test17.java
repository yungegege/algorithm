package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

public class Test17 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));

    }

    public static int[] printNumbers(int n) {
        int num = 0;
        int jinzhi = 9;
        for (int i = 0; i < n; i++) {
            num += jinzhi;
            jinzhi *= 10;
        }
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
