package com.cloudfly.algorithm.leetcode.normal;

/**
 * 最短路径
 */
public class Test_4 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 5, 7, 4},
                {5, 2, 6, 3, 5},
                {2, 4, 3, 5, 3},
                {4, 6, 8, 2, 7},
        };
        System.out.println(new Test_4().method(arr));
    }

    public int method(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
//        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i - 1][0];
        }
        for (int i = 1; i < arr[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + arr[i - 1][j], dp[i][j - 1] + arr[i][j - 1]);
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }
}
