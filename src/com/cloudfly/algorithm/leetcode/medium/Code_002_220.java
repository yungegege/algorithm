package com.cloudfly.algorithm.leetcode.medium;

import java.util.TreeSet;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-27 16:19
 */
public class Code_002_220 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        System.out.println(containsNearbyAlmostDuplicate(arr, 3, 0));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = treeSet.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= ((long) nums[i] + (long) t)) {
                return true;
            }
            treeSet.add((long) nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
