package com.cloudfly.algorithm.leetcode.oneweek.race199th;

/**
 * 重新排列字符串
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * 返回重新排列后的字符串。
 */
public class Test1 {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }

    public String restoreString(String s, int[] indices) {
        if (s==null || s.length()<2){
            return s;
        }
        char[] strArr = s.toCharArray();
        char[] arr = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            arr[indices[i]] = strArr[i];
        }
        return new String(arr);
    }
}
