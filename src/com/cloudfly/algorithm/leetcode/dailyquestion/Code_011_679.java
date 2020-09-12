package com.cloudfly.algorithm.leetcode.dailyquestion;

public class Code_011_679 {
    public static void main(String[] args) {
        System.out.println(new Code_011_679().judgePoint24(new int[]{8, 1, 6, 6}));
    }


    public boolean judgePoint24(int[] nums) {
        double[] arr = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        boolean b1 = digui(arr, 0, 24);
        boolean b2 = xuan2(arr);
        return b1 || b2;
    }

    public boolean xuan2(double[] nums) {
        int[][] arr1 = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}, {2, 3}};
        int[][] arr2 = {{2, 3}, {1, 3}, {1, 2}, {0, 3}, {0, 2}, {0, 1}};
        for (int i = 0; i < 6; i++) {
            double[] res1 = aaa(nums[arr1[i][0]], nums[arr1[i][1]]);
            double[] res2 = aaa(nums[arr2[i][0]], nums[arr2[i][1]]);
            for (int j = 0; j < res1.length; j++) {
                for (int k = 0; k < res2.length; k++) {
                    double[] res = aaa(res1[j], res2[k]);
                    for (int l = 0; l < res.length; l++) {
                        if (res[l] == 24) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    public double[] aaa(double a, double b) {
        if (a == 0) {
            return new double[]{0, b, -b};
        }
        if (b == 0) {
            return new double[]{0, a, -a};
        }
        return new double[]{a + b, a - b, b - a, a * b, a / b, b / a};
    }

    public boolean digui(double[] nums, int index, double num) {
        if (index == nums.length - 1 && Math.abs(num = nums[nums.length - 1])<0.01) {
            return true;
        }
        boolean res = false;
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            res = res || digui(nums, index + 1, num / nums[index]);
            if (num != 0) {
                res = res || digui(nums, index + 1, nums[index] / num);
            }
            res = res || digui(nums, index + 1, num - nums[index]);
            res = res || digui(nums, index + 1, nums[index] - num);
            res = res || digui(nums, index + 1, num * nums[index]);
            res = res || digui(nums, index + 1, num + nums[index]);
            swap(nums, index, i);
        }
        return res;
    }

    public void swap(double[] nums, int a, int b) {
        double temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
