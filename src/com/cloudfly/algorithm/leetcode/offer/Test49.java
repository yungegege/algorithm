package com.cloudfly.algorithm.leetcode.offer;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * 1 是丑数。
 * n 不超过1690。
 */
public class Test49 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(3));
    }

    public static int nthUglyNumber(int n) {
        int i = 1;
        int[] dp = new int[n];
        int a2 = 0;
        int a3 = 0;
        int a5 = 0;
        dp[0] = 1;
        while (i < n) {
            dp[i] = Math.min(Math.min(dp[a2] * 2, dp[a3] * 3), dp[a5] * 5);
            if (dp[i]==dp[a2]*2){
                a2++;
            }
            if (dp[i]==dp[a3]*3){
                a3++;
            }
            if (dp[i]==dp[a5]*5){
                a5++;
            }
            i++;
        }
        return dp[n-1];
    }
}
