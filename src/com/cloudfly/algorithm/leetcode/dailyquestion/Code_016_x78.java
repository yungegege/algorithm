package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Code_016_x78 {

    public static void main(String[] args) {
        System.out.println(new Code_016_x78().subsets(new int[]{1, 2, 3}));
    }

    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        if (nums.length == 0) {
            return lists;
        }
        digui(nums, 0);
        lists.add(list);
        return lists;
    }

    public void digui(int[] nums, int curIndex) {
        for (int i = curIndex; i < nums.length; i++) {
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            digui(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
