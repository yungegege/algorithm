package com.cloudfly.algorithm.leetcode.gaopin;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 */
public class Code_006_006 {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int cycleLen = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += cycleLen) {
                sb.append(s.charAt(j));
                if (i != 0 && i != numRows - 1 && j - 2 * i + cycleLen < s.length()) {
                    sb.append(s.charAt(j + cycleLen - 2 * i));
                }
            }
        }
        return sb.toString();
    }
}
