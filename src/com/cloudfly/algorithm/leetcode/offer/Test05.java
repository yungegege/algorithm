package com.cloudfly.algorithm.leetcode.offer;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-07 14:39
 */
public class Test05 {
    public static void main(String[] args) {
        String str = "We are happy.";
        System.out.println(replaceSpace(str));
        System.out.println(replaceSpace2(new StringBuffer(str)));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            sb.append(a == ' ' ? "%20" : a);
        }
        return sb.toString();
    }

    public static String replaceSpace2(StringBuffer s) {
        int len1 = s.length();
        for (int i = 0; i < len1; i++) {
            if (s.charAt(i) == ' ') {
                s.append("  ");
            }
        }
        int len2 = s.length();
        for (int i = len1 - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                s.setCharAt(--len2, '0');
                s.setCharAt(--len2, '2');
                s.setCharAt(--len2, '%');
            } else {
                s.setCharAt(--len2, s.charAt(i));
            }
        }
        return s.toString();
    }
}
