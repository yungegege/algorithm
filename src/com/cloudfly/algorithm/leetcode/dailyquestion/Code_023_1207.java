package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * 示例 1：
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * <p>
 * 示例 2：
 * 输入：arr = [1,2]
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 */
public class Code_023_1207 {
    public static void main(String[] args) {
        System.out.println(new Code_023_1207().uniqueOccurrences(new int[]{
                1, 2, 2, 1, 1, 3
        }));
    }

    public boolean uniqueOccurrences(int[] arr) {
        int[] countArr = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            countArr[1000 + arr[i]]++;
        }
        int[] res = new int[arr.length + 1];
        for (int i = 0; i < countArr.length; i++) {
            // 数字i出现的次数为count次
            int count = countArr[i];
            if (count == 0) {
                continue;
            }
            if (res[count] == 0) {
                res[count] = 1;
            } else {
                return false;
            }
        }
        return true;

    }

    public boolean uniqueOccurrences2(int[] arr) {
        int[] count = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            count[1000 + arr[i]]++;
        }
        Set<Integer> set = new HashSet<>();
        for (int value : count) {
            if (value == 0)
                continue;
            if (!set.add(value))//如果存储失败，说明有重复的
                return false;
        }
        return true;
    }
}
