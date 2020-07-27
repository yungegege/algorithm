package com.cloudfly.algorithm.leetcode.twoweek.race31th;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 * 请你返回 s 中好分割的数目。
 * <p>
 * 输入：s = "aacaba"
 * 输出：2
 * 解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
 * ("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(numSplits("aacaba"));
    }

    public static int numSplits(String s) {
        if (s.length() < 2) {
            return 0;
        }
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        Map<Character, Integer> leftMap = new HashMap<>();
        leftMap.put(s.charAt(0), 1);
        left[0] = 1;
        Map<Character, Integer> rightMap = new HashMap<>();
        rightMap.put(s.charAt(s.length() - 1), 1);
        right[s.length() - 1] = 1;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            left[i] = left[i - 1];
            if (leftMap.get(s.charAt(i)) == null) {
                leftMap.put(s.charAt(i), 1);
                left[i] += 1;
            }
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            if (rightMap.get(s.charAt(i)) == null) {
                rightMap.put(s.charAt(i), 1);
                right[i] += 1;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (left[i] == right[i + 1]) {
                res += 1;
            }
        }
        return res;
    }
}
