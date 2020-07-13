package com.cloudfly.algorithm.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class Test16 {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow2(2.00000, 10));
        System.out.println(myPow2(2.10000, 3));
        System.out.println(myPow2(2.00000, -2));
        System.out.println(-3 % 2);
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-3));

    }

    public static double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == -1) {
            return 1 / x;
        }
        if (n == 1) {
            return x;
        }
        double a = myPow(x, n / 2);
        return myPow(x, n % 2) * a * a;
    }

    public static double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1;
        long num = n;
        if (num < 0) {
            x = 1 / x;
            num = -num;
        }
        while (num > 0) {
            if ((num & 1) == 1) {
                res *= x;
            }
            x *= x;
            num >>= 1;
        }
        return res;
    }
}
