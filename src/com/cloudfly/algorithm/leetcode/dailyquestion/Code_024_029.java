package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class Code_024_029 {
    public static void main(String[] args) {
        System.out.println(new Code_024_029().divide(-2147483648, -1));
    }

    public int divide(int dividend, int divisor) {
        int a = 1;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            a = -1;
        }
        long n = divisor;
        long longDividend = dividend;
        longDividend = Math.abs(longDividend);
        n = Math.abs(n);

        long m = 1;
        List<Long> aList = new ArrayList<>();
        List<Long> bList = new ArrayList<>();
        while (n <= longDividend) {
            aList.add(n);
            bList.add(m);
            n = n + n;
            m = m + m;
        }
        long res = 0;
        long sum = 0;
        for (int i = aList.size() - 1; i >= 0; i--) {
            if (sum + aList.get(i) <= longDividend) {
                sum += aList.get(i);
                res += bList.get(i);
            }
        }
        return res > Integer.MAX_VALUE && a==-1 ? Integer.MAX_VALUE * a : (int) res * a;
    }
}
