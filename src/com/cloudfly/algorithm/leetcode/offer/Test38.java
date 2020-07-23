package com.cloudfly.algorithm.leetcode.offer;

import java.util.*;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Test38 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("aab")));
        System.out.println(Arrays.toString(permutation("abcd")));
    }

    private static List<String> list;

    public static String[] permutation(String s) {
        list = new ArrayList<>();
        digui(s.toCharArray(), 0);
        return list.toArray(new String[0]);
    }

    private static void digui(char[] arr, int start) {
        if (start == arr.length - 1) {
            list.add(String.valueOf(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (set.contains(arr[i])){
                continue;
            }
            set.add(arr[i]);
            swap(arr,start,i);
            digui(arr,start+1);
            swap(arr,start,i);
        }
    }

    private static void swap(char[] arr, int start, int i) {
        char temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }

    /**
     * 笨方法
     */
    public static String[] permutation2(String s) {
        if (s == null || "".equals(s)) {
            return new String[0];
        }
        List<List<Character>> lists = digui2(s);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < lists.size(); i++) {
            StringBuffer sb = new StringBuffer();
            for (Character character : lists.get(i)) {
                sb.append(character);
            }
            set.add(sb.toString());
        }
        String[] res = new String[set.size()];
        int i = 0;
        for (String str : set) {
            res[i++] = str;
        }
        return res;
    }

    private static List<List<Character>> digui2(String s) {
        List<List<Character>> res = new ArrayList<>();
        if (s.length() == 1) {
            List<Character> list = new ArrayList<>();
            list.add(s.charAt(0));
            res.add(list);
            return res;
        }
        List<List<Character>> lists = digui2(s.substring(1));
        for (List<Character> list : lists) {
            for (int i = 0; i <= list.size(); i++) {
                List<Character> list1 = new ArrayList<>(list);
                list1.add(i, s.charAt(0));
                res.add(list1);
            }
        }
        return res;
    }
}
