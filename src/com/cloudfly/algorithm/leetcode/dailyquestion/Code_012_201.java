package com.cloudfly.algorithm.leetcode.dailyquestion;

/**
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 */
public class Code_012_201 {

    public static void main(String[] args) {
        // 0101
        // 0110
        // 0111
        System.out.println(new Code_012_201().rangeBitwiseAnd(5, 7));
        System.out.println(new Code_012_201().rangeBitwiseAnd2(5, 7));
        System.out.println(Integer.MAX_VALUE);
    }

    public int rangeBitwiseAnd3(int m, int n) {
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m<n){
            n = n&(n-1);
        }
        return n;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int num = 1;
        while (num < Integer.MAX_VALUE - m && m + num <= n && m != 0) {
            if ((m & num) == num) {
                m -= num;
            }
            num = num << 1;
        }
        return m;
    }
}
