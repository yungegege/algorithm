package com.cloudfly.algorithm.leetcode.twoweek.race31th;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
//        int[] ints = {1, 3, 5};
//        int[] ints = {2,4,6};
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
//        int[] ints = {100,100,99,99};
//        int[] ints = {7};
        System.out.println(numOfSubarrays(ints));
    }

    public static int numOfSubarrays(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        // 存所有奇数的索引
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                list.add(i);
            }
        }
        list.add(arr.length);
        int a = 0;
        int b = 0;
        long res = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (i % 2 == 1) {
                a = a + (list.get(i) - list.get(i - 1));
                res += a * (list.get(i + 1) - list.get(i));
            } else {
                b = b + (list.get(i) - list.get(i - 1));
                res += b * (list.get(i + 1) - list.get(i));
            }
        }
        return (int) (res % 1000000007);
    }

    public static int numOfSubarrays2(int[] arr) {
        // 奇数
        int a = 0;
        // 偶数
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                a++;
            } else {
                b++;
            }
        }
        if (a == 0) {
            return 0;
        }
        long[] dp = new long[a + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] * i;
        }
        long res = 0;
        for (int i = 1; i <= a; i += 2) {
            // c a i
            res += ((dp[a] / dp[(a - i)]) / dp[i]) * (b + 1);
        }
        return (int) (res % 1000000007);
    }
}
