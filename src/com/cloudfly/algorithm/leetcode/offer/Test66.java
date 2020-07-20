package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class Test66 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                7, 2, 2, 4, 2, 1, 8, 8, 9, 6, 8, 9, 6, 3, 2, 1
        };
        System.out.println(Arrays.toString(constructArr(arr)));
        System.out.println(Arrays.toString(constructArr2(arr)));
    }

    /**
     * 1 2 3 4 5
     * 0   2 3 4 5
     * 0 1   3 4 5
     * 0 1 2   4 5
     * 0 1 2 3   5
     * 0 1 2 3 4
     */
    public static int[] constructArr(int[] a) {
        if (a.length < 2) {
            return a;
        }
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i <= a.length - 1; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        System.out.println(Arrays.toString(res));
        int tmp = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] = res[i] * tmp;
            tmp *= a[i];
        }
        return res;
    }

    public static int[] constructArr2(int[] a) {
        if (a.length < 2) {
            return a;
        }
        int[] pre = new int[a.length];
        pre[0] = 1;
        int num = a[0];
        for (int i = 1; i < a.length; i++) {
            pre[i] = num;
            if (a[i] != 1) {
                for (int j = 0; j < i; j++) {
                    pre[j] *= a[i];
                }
                num *= a[i];
            }
        }
        return pre;
    }
}
