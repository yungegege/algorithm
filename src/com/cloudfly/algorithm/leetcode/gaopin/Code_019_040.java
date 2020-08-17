package com.cloudfly.algorithm.leetcode.gaopin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_019_040 {

    public static void main(String[] args) {
        Code_019_040 code_019_040 = new Code_019_040();
        int[] arr = {
                2, 3, 6, 7
        };
        List<List<Integer>> lists = code_019_040.combinationSum2(arr, 7);
        lists.forEach(System.out::println);
    }

    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        Arrays.sort(candidates);
        digui(candidates, 0, target);
        return lists;
    }

    private void digui(int[] candidates, int curIndex, int target) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = curIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > curIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            digui(candidates, i + 1, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        digui1(candidates, 0, 0, target);
        return lists;
    }

    private void digui1(int[] candidates, int curIndex, int sum, int target) {
        if (sum == target) {
            lists.add(new ArrayList<>(list));
        }
        if (curIndex >= candidates.length || sum >= target) {
            return;
        }
        digui1(candidates, curIndex + 1, sum, target);
        list.add(candidates[curIndex]);
        digui1(candidates, curIndex + 1, sum + candidates[curIndex], target);
        list.remove(list.size() - 1);

    }
}
