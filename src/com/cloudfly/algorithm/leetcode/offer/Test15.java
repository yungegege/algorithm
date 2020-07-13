package com.cloudfly.algorithm.leetcode.offer;

public class Test15 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(5)+" "+Integer.bitCount(5));
        System.out.println(hammingWeight(-1)+" "+Integer.bitCount(-1));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            // 注意这里是无符号右移，否则会死循环，因为10000000 00000000 00000000 00000000 一直不等于0
            n = n>>>1;
        }
        return count;
    }
}
