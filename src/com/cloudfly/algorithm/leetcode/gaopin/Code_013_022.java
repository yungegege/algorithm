package com.cloudfly.algorithm.leetcode.gaopin;

import com.cloudfly.algorithm.designpattern.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 输入：
 * 4
 * 输出：
 * ["()()()()","(()())()","(()(()))","()()(())","(())()()","(((())))","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"]
 * 预期：
 * ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
 */
public class Code_013_022 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> list;

    public static List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        // 还剩n个左括号，n个右括号
        digui(n, n, 0, new char[2 * n]);
        return list;
    }

    private static void digui(int l, int r, int i, char[] arr) {
        if (r == 0) {
            if (i != 0) {
                list.add(new String(arr));
            }
        }
        if (l>0){
            arr[i] = '(';
            digui(l - 1, r, i + 1, arr);
        }
        if (l < r) {
            arr[i] = ')';
            digui(l, r - 1, i + 1, arr);
        }
    }
}
