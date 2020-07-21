package com.cloudfly.algorithm.leetcode.offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Test46 {

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    /**
     * dp解
     */
    public static int translateNum(int num) {
        int[] dp = new int[String.valueOf(num).length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            int a = num % 100;
            if (a < 26 && a > 9) {
                if (i - 2 >= 0) {
                    dp[i] += dp[i - 2];
                } else {
                    dp[i] += 1;
                }
            }
            num /= 10;
        }
        return dp[dp.length - 1];
    }

    /**
     * 递归解
     */
    public static int translateNum2(int num) {
        return digui(String.valueOf(num));
    }

    private static int digui(String str) {
        if (str.length() <= 1) {
            return str.length();
        }
        if (str.length() == 2) {
            if (Integer.parseInt(str) <= 25 && str.charAt(0) != '0') {
                return 2;
            } else {
                return 1;
            }
        }
        int res = digui(str.substring(1));
        if (str.charAt(0) == '0') {
            return res;
        }
        if (Integer.parseInt(str.substring(0, 2)) <= 25) {
            res += digui(str.substring(2));
        }
        return res;
    }
}
