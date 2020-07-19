package com.cloudfly.algorithm.leetcode.offer;

import java.util.Stack;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class Test58_1 {

    public static void main(String[] args) {
        System.out.println(reverseWords("I am a student. "));
    }

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        s = s.trim();
        boolean flag = true;
        int start = -1;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == ' ') {
                if (flag) {
                    stack.push(s.substring(++start, i));
                    flag = false;
                }
                start = i;
            } else {
                flag = true;
            }
        }
        stack.push(s.substring(++start));
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (!stack.isEmpty()){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
