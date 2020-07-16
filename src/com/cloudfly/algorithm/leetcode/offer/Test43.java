package com.cloudfly.algorithm.leetcode.offer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * *
 * * 输入：n = 12
 * * 输出：5
 * *
 * * 输入：n = 13
 * * 输出：6
 */
public class Test43 {

    public static void main(String[] args) {
        System.out.println(countDigitOne(20));
        System.out.println(countDigitOne(100));
        System.out.println(countDigitOne(40));
        System.out.println(countDigitOne(66));
        System.out.println(countDigitOne(666));
        System.out.println(countDigitOne(6666));

    }

    /**
     * 1 - 9   1+9*0=1个
     * 10 - 99  10+9*1 = 19
     * 100 - 999    100+9*(19+1) = 280
     * 1000 - 9999    1000+9*(280+19+1) = ?
     */
    public static int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }

        long sum = 0;
        long num = 0;
        long start = 1;
        int i = 1;
        while (start * 10 <= n) {
            num = start + 9 * sum;
            sum += num;
            start *= 10;
            i++;
        }
        if (n < 2 * start) {
            return (int)(sum + (n - start + 1) + countDigitOne((int)(n - start)));
        } else {
            long res = 2 * sum + start;
            long jian = 2 * start;
            for (long j = 3 * start; j <= n; j += start) {
                res += sum;
                jian = j;
            }
            return (int)(res + countDigitOne((int)(n - jian)));
        }
    }
}
