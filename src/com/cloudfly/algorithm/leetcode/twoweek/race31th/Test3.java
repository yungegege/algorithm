package com.cloudfly.algorithm.leetcode.twoweek.race31th;

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

    }

    public int numSplits(String s) {
        int[] arr = new int[26];
        int left = 0;
        int right = s.length() - 1;
        int leftNum = 0;
        int rightNum = 0;
        int res = 0;
        while (left < right) {
            while (arr[s.charAt(left) - 'a'] == 1) {
                left++;

            }
            arr[s.charAt(left) - 'a'] = 1;
            leftNum++;
            while (arr[s.charAt(right) - 'a'] == 2) {
                right--;
            }
            arr[s.charAt(right) - 'a'] = 2;
            rightNum++;
            if (left+1==right){
                res++;
            }
        }
        while (left>=right){

            left++;
        }
        return res;
    }
}
