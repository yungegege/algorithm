package com.cloudfly.algorithm.leetcode.offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Test14_1 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(2));
        System.out.println(cuttingRope(10));
        System.out.println(cuttingRope(20));
        System.out.println(3 * 3 * 3 * 3 * 3 * 3 * 2);
    }

    /**
     * dp求解
     * @param n
     * @return
     */
    public static int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
//        arr[4] = 4;
        for (int i = 4; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= (i + 1) / 2; j++) {  // i=5 j=1
                if (max < j * arr[i - j]) {
                    max = j * arr[i - j];
                }
            }
            arr[i] = max;
        }
        return arr[n];
    }
}

