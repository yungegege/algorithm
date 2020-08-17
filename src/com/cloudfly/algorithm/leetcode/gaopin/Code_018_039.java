package com.cloudfly.algorithm.leetcode.gaopin;

import java.util.ArrayList;
import java.util.List;

public class Code_018_039 {
    public static void main(String[] args) {
        Code_018_039 code_018_039 = new Code_018_039();
        int[] arr = {
                2, 3, 6, 7
        };
        List<List<Integer>> lists = code_018_039.combinationSum(arr, 7);
        lists.forEach(System.out::println);
    }

    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        digui(candidates, 0, target);
        return lists;
    }

    private void digui(int[] candidates, int curIndex, int target) {
        if (target==0){
            lists.add(new ArrayList<>(list));
        }
        if (target<=0 || curIndex>=candidates.length){
            return;
        }
        for (int i = curIndex; i < candidates.length; i++) {
            if (candidates[i]>target){
                continue;
            }
            list.add(candidates[i]);
            digui(candidates,i,target-candidates[i]);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        digui2(candidates, 0, 0, target);
        return lists;
    }

    private void digui2(int[] candidates, int curIndex, int sum, int target) {
        if (curIndex < candidates.length && sum == target) {
            lists.add(new ArrayList<>(list));
        }
        if (curIndex >= candidates.length || sum >= target) {
            return;
        }
        digui2(candidates, curIndex + 1, sum, target);
        list.add(candidates[curIndex]);
        digui2(candidates, curIndex, sum + candidates[curIndex], target);
        digui2(candidates, curIndex + 1, sum + candidates[curIndex], target);
        list.remove(list.size() - 1);

    }
}
