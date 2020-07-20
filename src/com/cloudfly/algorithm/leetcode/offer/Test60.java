package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * <p>
 * 示例 2:
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 */
public class Test60 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(3)));
        System.out.println(Arrays.toString(twoSum(2)));
    }

    public static double[] twoSum(int n) {
        // n个筛子 m种可能点数
        int m = 5 * n + 1;
        double[] res = new double[m];
        int[][] arr = new int[n][6 * n];
        for (int i = 0; i < 6; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                // 1,0  俩筛子出来1
                for (int k = 1; k <= 6; k++) {
                    if (j - k >= 0) {
                        arr[i][j] += arr[i - 1][j - k];
                    }else {
                        break;
                    }
                }
            }
        }
        int a = 1;
        int n1 = n;
        while (n1 > 0) {
            a *= 6;
            n1 -= 1;
        }
        for (int i = 0; i < m; i++) {
            res[i] = arr[n - 1][n - 1 + i]*1.0 / a;
        }
        return res;
    }

    /**
     * n个筛子扔出来m点,实际上就是n个1~6的正整数组成m,有几种方案
     */
    public static double[] twoSum2(int n) {
        // 例如2个筛子 范围是2-12
        double[] res = new double[5 * n + 1];
        int a = 1;
        int n1 = n;
        while (n1 > 0) {
            a *= 6;
            n1 -= 1;
        }
        // i 0~10
        for (int i = 0; i <= res.length / 2; i++) {
            double num = getAllCount(n, n + i);
            res[i] += num / a;
        }
        for (int i = res.length - 1; i >= res.length / 2; i--) {
            res[i] = res[res.length - 1 - i];
        }
        return res;
    }

    /**
     * n个筛子扔出来m点,实际上就是n个1~6的正整数组成m,有几种方案，
     * 以下6种之和
     * n-1个筛子扔出来m-1点
     * n-1个筛子扔出来m-2点
     * n-1个筛子扔出来m-3点
     * n-1个筛子扔出来m-4点
     * n-1个筛子扔出来m-5点
     * n-1个筛子扔出来m-6点
     *
     * @param n 筛子个数
     * @param m 点数
     * @return n个筛子, 扔出来m点的可能个数
     */
    private static double getAllCount(int n, int m) {
        if (m <= 0) {
            return 0;
        }
        if (n == 1) {
            if (m <= 6) {
                return 1;
            } else {
                return 0;
            }
        }
        return getAllCount(n - 1, m - 1) + getAllCount(n - 1, m - 2) + getAllCount(n - 1, m - 3)
                + getAllCount(n - 1, m - 4) + getAllCount(n - 1, m - 5) + getAllCount(n - 1, m - 6);
    }
}
