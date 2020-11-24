package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.Stack;

public class Code_027_402 {

    public static void main(String[] args) {
        System.out.println(new Code_027_402().removeKdigits("1432219", 3));
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(i) < stack.peek() && k-- > 0) {
                stack.pop();
            }
            stack.push(num.charAt(i));
        }
        for (int i = 0; i < k; i++) {
            stack.pop();
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb = sb.reverse();
        StringBuilder res = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < sb.length(); i++) {
            if (flag && sb.charAt(i) == '0') {
                continue;
            }
            flag = false;
            res.append(sb.charAt(i));
        }

        return res.length() == 0 ? "0" : res.toString();
    }
}
