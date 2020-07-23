package com.cloudfly.algorithm.leetcode.offer;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 */
public class Test19 {

    public static void main(String[] args) {
//        System.out.println(isMatch("aaa", "ab*ac*a"));
//        System.out.println(isMatch("a.a", "ab*ac*a"));
//        System.out.println(isMatch("aa.a", "ab*a"));
        System.out.println(isMatch("s*is*p*.", "sispp*pa"));
        System.out.println(isMatch("sispp*pa", "s*is*p*."));
        System.out.println(isMatch2("sispp*pa", "s*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p));
        }
        return first_match && isMatch(s.substring(1), p.substring(1));

    }

    public static boolean isMatch2(String s, String p) {
        return digui(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private static boolean digui(char[] s, int sIndex, char[] p, int pIndex) {
        if (sIndex == s.length && pIndex == p.length) {
            return true;
        }
        if (sIndex > s.length || pIndex > p.length) {
            return false;
        }
        boolean res = false;
        if (sIndex < s.length && pIndex < p.length && s[sIndex] == p[pIndex]) {
            if (sIndex < s.length - 1 && pIndex < p.length - 1 && s[sIndex + 1] == '*' && p[pIndex + 1] == '*') {
                res = res || digui(s, sIndex + 2, p, pIndex + 2);
                res = res || digui(s, sIndex, p, pIndex + 2);
                res = res || digui(s, sIndex + 2, p, pIndex);
            } else {
                if (sIndex < s.length - 1 && s[sIndex + 1] == '*') {
                    res = res || digui(s, sIndex + 2, p, pIndex + 1);
                    res = res || digui(s, sIndex, p, pIndex + 1);
                    res = res || digui(s, sIndex + 2, p, pIndex);
                } else if (pIndex < p.length - 1 && p[pIndex + 1] == '*') {
                    res = res || digui(s, sIndex + 1, p, pIndex + 2);
                    res = res || digui(s, sIndex + 1, p, pIndex);
                    res = res || digui(s, sIndex, p, pIndex + 2);
                } else {
                    res = res || digui(s, sIndex + 1, p, pIndex + 1);
                }
            }
            return res;
        } else {
            if (sIndex < s.length - 1 && s[sIndex + 1] == '*' || pIndex < p.length - 1 && p[pIndex + 1] == '*') {
                if (sIndex < s.length - 1 && s[sIndex + 1] == '*') {
                    res = res || digui(s, sIndex + 2, p, pIndex);
                    if (s[sIndex] == '.') {
                        res = res || digui(s, sIndex, p, pIndex + 1);
                        res = res || digui(s, sIndex + 2, p, pIndex + 1);
                    }
                }
                if (pIndex < p.length - 1 && p[pIndex + 1] == '*') {
                    res = res || digui(s, sIndex, p, pIndex + 2);
                    if (p[pIndex] == '.') {
                        res = res || digui(s, sIndex + 1, p, pIndex);
                        res = res || digui(s, sIndex + 1, p, pIndex + 2);
                    }
                }
            } else {
                if (sIndex < s.length && s[sIndex] == '.') {
                    res = res || digui(s, sIndex + 1, p, pIndex + 1);
                }
                if (pIndex < p.length && p[pIndex] == '.') {
                    res = res || digui(s, sIndex + 1, p, pIndex + 1);
                }
            }
            return res;
        }
    }
}
