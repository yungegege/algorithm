package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Code_022_127 {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog");
        System.out.println(new Code_022_127().ladderLength("hit", "dog", wordList));
    }

    Set<String> set;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set = new HashSet<>(wordList);
        return digui(beginWord.toCharArray(), endWord.toCharArray(), 1);
    }

    private int digui(char[] a, char[] b, int count) {
        if (count > 1 && !set.contains(new String(a))) {
            return -1;
        }
        if (new String(a).equals(new String(b))) {
            return count;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                char c = a[i];
                a[i] = b[i];
                int num = digui(a, b, count + 1);
                if (num != -1) {
                    return num;
                }
                a[i] = c;
            }
        }
        return -1;
    }
}
