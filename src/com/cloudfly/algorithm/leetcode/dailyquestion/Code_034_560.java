package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 */
public class Code_034_560 {
    public static void main(String[] args) {
        System.out.println(new Code_034_560().subarraySum2(new int[]{
                1, 1, 1
        }, 2));
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public int subarraySum2(int[] nums, int k) {
        int res = 0;
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            for (int j = 0; j < i; j++) {
                if (sum[j] == sum[i] - k) {
                    res++;
                }
            }
        }
        return res;
    }
}
