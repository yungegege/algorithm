package com.cloudfly.algorithm.leetcode.dailyquestion;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class Code_013_459 {

    public static void main(String[] args) {
        System.out.println(new Code_013_459().repeatedSubstringPattern("abab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        for (int i = 2; i < s.length() / 2; i++) {
            if (s.length() % i == 0 && s.equals(s.substring(i)+s.substring(0,i))) {
                return true;
            }
        }
        return false;
    }
}
