package com.cloudfly.algorithm.leetcode.oneweek.race215th;

import java.lang.reflect.Proxy;

public class Test_3 {

    public static void main(String[] args) {
        System.out.println(new Test_3().minOperations(new int[]{
                8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309
        }, 134365));
    }

    public int minOperations(int[] nums, int x) {
        int L = 0;
        int R = nums.length - 1;
        return digui(nums, L, R, x);
    }

    public int digui(int[] nums, int L, int R, int x) {
        if (x < 0 || L > R) {
            return -1;
        }
        if (x == 0) {
            return 0;
        }
        if (L==R && nums[L]==x){
            return 1;
        }
        int numL = digui(nums, L + 1, R, x - nums[L]);
        int numR = digui(nums, L, R - 1, x - nums[R]);
        if (numL == -1 && numR == -1) {
            return -1;
        }
        if (numL == -1) {
            return numR + 1;
        }
        if (numR == -1) {
            return numL + 1;
        }
        return Math.min(numL, numR) + 1;
    }
}
