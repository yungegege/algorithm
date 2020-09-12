package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.*;

/**
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 * <p>
 * 示例:
 * <p>
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 * <p>
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class Code_014_491 {

    public static void main(String[] args) {
        Code_014_491 code_014_491 = new Code_014_491();
        List<List<Integer>> res = code_014_491.findSubsequences(new int[]{1,2,1,1});
        System.out.println(res);
    }

    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> findSubsequences(int[] nums) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        digui(nums, 0);
        return lists;
    }

    private void digui(int[] nums, int curIndex) {
        if (curIndex > nums.length) {
            return;
        }
        if (list.size() > 1) {
            lists.add(new ArrayList<>(list));
        }
        int max = -101;
        for (int i = curIndex; i < nums.length; i++) {
            if (list.size() == 0 || nums[i] >= list.get(list.size() - 1) && nums[i]>max) {
                max = nums[i];

                list.add(nums[i]);
                digui(nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
