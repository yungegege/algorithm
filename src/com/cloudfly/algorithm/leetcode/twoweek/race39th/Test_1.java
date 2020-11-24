package com.cloudfly.algorithm.leetcode.twoweek.race39th;

import java.util.List;

public class Test_1 {
    public static void main(String[] args) {

    }

    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) {
            return res;
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = sum(code, i, k);
        }
        return res;
    }

    /**
     * 从i
     *
     * @param code
     * @param index
     * @param k
     * @return
     */
    private int sum(int[] code, int index, int k) {
        int sum = 0;
        for (int i = 0; i < Math.abs(k); i++) {
            if (k > 0) {
                index = (index + 1) % code.length;
            } else {
                index = index - 1 < 0 ? code.length - 1 : index - 1;
            }
            sum += code[index];
        }
        return sum;
    }
}
