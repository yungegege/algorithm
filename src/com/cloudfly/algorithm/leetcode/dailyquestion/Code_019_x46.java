package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.gaopin.Code_015_031;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Code_019_x46 {

    public static void main(String[] args) {
        System.out.println(new Code_019_x46().permute(new int[]{1, 2, 3}));
    }

    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return lists;
        }
        list = new ArrayList<>();
        digui(nums, 0);
        return lists;
    }

    private void digui(int[] nums, int curIndex) {
        if (curIndex == nums.length) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = curIndex; i < nums.length; i++) {
            swap(nums, i, curIndex);
            list.add(nums[curIndex]);
            digui(nums, curIndex + 1);
            list.remove(list.size() - 1);
            swap(nums, i, curIndex);
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
