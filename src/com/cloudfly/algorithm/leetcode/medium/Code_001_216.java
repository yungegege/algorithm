package com.cloudfly.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class Code_001_216 {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 18);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    static List<List<Integer>> lists;

    public static List<List<Integer>> combinationSum3(int k, int n) {
        lists = new ArrayList<>();
        digui(0, k, n, new ArrayList<>());
        return lists;
    }

    private static void digui(int s, int k, int n, List<Integer> list) {
        if (n < 0) {
            return;
        }
        if (k == 0) {
            if (n == 0) {
                lists.add(new ArrayList<>(list));
            } else {
                return;
            }
        }
        for (int i = 1; i <= 9 - s; i++) {
            list.add(s + i);
            digui(i + s, k - 1, n - (s + i), list);
            list.remove(list.size() - 1);
        }
    }
}
