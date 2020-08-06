package com.cloudfly.algorithm.leetcode.gaopin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Code_009_017 {

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    static List<String> list;

    static Map<Character, String> map = new HashMap<>();

    public static List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "oprs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        char[] arr = new char[digits.length()];
        digui(digits, 0, arr);
        return list;
    }

    private static void digui(String digits, int i, char[] arr) {
        if (i == digits.length()) {
            String s = new String(arr);
            if (!"".equals(s)){
                list.add(s);
            }
            return;
        }
        int n = i+1;
        for (int j = 0; j < map.get(digits.charAt(i)).length(); j++) {
            arr[i] = map.get(digits.charAt(i)).charAt(j);
            digui(digits, n, arr);
        }
    }
}
