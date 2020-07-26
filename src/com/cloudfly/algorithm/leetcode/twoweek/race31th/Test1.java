package com.cloudfly.algorithm.leetcode.twoweek.race31th;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(countOdds(3,7));
        System.out.println(countOdds(2,8));
        System.out.println(countOdds(8,10));
        System.out.println(countOdds(8,8));
        System.out.println(countOdds(7,7));
    }

    public static int countOdds(int low, int high) {
        int res = 0;
        if (low % 2 == 1) {
            low += 1;
            res += 1;
        }
        if (high % 2 == 1) {
            high -= 1;
            res += 1;
        }
        return res + (high - low) / 2;
    }
}
