package com.cloudfly.algorithm.leetcode.offer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。   0......1  1
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数，求任意第n位对应的数字。
 */
public class Test44 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(5));
        System.out.println(findNthDigit(10));
        System.out.println(findNthDigit(13));
        System.out.println(findNthDigit(19));
        System.out.println(findNthDigit(100));
        System.out.println(findNthDigit(1000000000));
    }

    /**
     * 0-9  1位数 10个  长度 1 * 10 = 10
     * 10-99  2位数 90个  长度  2 * 90 = 180
     * 100-999  3位数 900个 长度 3 * 900 = 2700
     * ... ...    n位数 9*10^(n-1)个
     */
    public static int findNthDigit(int n) {
        long sum = 0;
        long start = 1;
        int i = 1;
        while (sum + i * 9 * start < n) {
            sum = sum + i * 9 * start;
            start *= 10;
            i++;
        }
        int a = (int) ((n - sum) / i);
        int b = (int) ((n - sum) % i);
        long num = start + a;
        if (b == 0) {
            return (int) ((num-1) % 10);
        }
        // 12345 b = 1
        for (int j = 0; j < i - b; j++) {
            num /= 10;
        }
        return (int) (num % 10);
    }

}
