package com.cloudfly.algorithm.jike;

import java.util.Stack;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-06-04 17:20
 */
public class Luoji {

    public static void main(String[] args) {
        String[] arr = new String[]{
                "G|A|B|(A|(B&C))&(D|E)",
                "G|A|B|(A|(B&C))&(D|E",
                ")G|A|B|(A|(B&C))&(D|E)",
                "G|A|B|(A|(B&))&(D|E)"
        };

        for (int i = 1; i <= arr.length; i++) {
            try {
                arr[i - 1] = process(arr[i - 1]);
                System.out.println("第" + i + "个字符串解析成功: " + arr[i - 1]);
            } catch (Exception e) {
                System.out.println("第" + i + "个字符串: " + arr[i - 1] + " " + e.getMessage());
            }
        }
    }

    private static String process(String str) throws Exception {
        Stack<String> stack = new Stack<>();
        char[] chars = str.toCharArray();
        int i = 0;
        stack.push(String.valueOf(chars[0]));
        int num = 0;
        if (isLeftSign(chars[i])) {
            num++;
        } else if (isRightSign(chars[i])) {
            num--;
        }
        while (!stack.isEmpty() && i < chars.length - 1) {
            i++;
            char a = chars[i];
            // 验证语法
            verify(stack, a, num);
            // 如果是字母
            if (isLetter(a)) {
                // 如果栈顶是左括号,直接入栈，如果有左括号也直接入栈
                if (isLeftSign(stack.peek().toCharArray()[0]) || num > 0) {
                    stack.push(String.valueOf(a));
                } else {
                    // 合并一波
                    mergeStr(stack, a, num, i, chars);
                }
            } else if (isLeftSign(a)) {
                // 左括号直接入栈，并且num++
                num++;
                stack.push(String.valueOf(a));
            } else if (isRightSign(a)) {
                // 如果是右括号,要出一波栈了,并且num--
                num--;
                mergeStr(stack, a, num, i, chars);
            } else {
                // 其他& | ,直接入栈
                stack.push(String.valueOf(a));
            }
        }
        if (num != 0) {
            throw new Exception("括号不匹配");
        }
        stack.push(stack.peek().substring(1, stack.pop().length() - 1));
        return stack.pop();
    }

    private static void verify(Stack<String> stack, char a, int num) throws Exception {
        if (num < 0) {
            throw new Exception("右括号多了");
        }
        if (isLetter(a) && isLetter(stack.peek().toCharArray()[0])) {
            throw new Exception("字母之间没有别的字符");
        }
        if (isRightSign(a) && ("&".equals(stack.peek()) || "|".equals(stack.peek()))) {
            throw new Exception("存在&)或者|)");
        }
    }

    private static void mergeStr(Stack<String> stack, char a, int num, int i, char[] chars) {
        StringBuffer sb = new StringBuffer();
        // 这个是字母，栈顶是操作符，并且没有左括号，就要加一波括号了
        if (isLetter(a)) {
            String operate = String.valueOf(stack.pop());
            String leftStr = String.valueOf(stack.pop());
            sb.append("(");
            sb.append(leftStr);
            sb.append(operate);
            sb.append(a);
            sb.append(")");
            stack.push(sb.toString());
        } else {
            // 这个是右括号
            String firstStr = String.valueOf(stack.pop());
            String secondStr = String.valueOf(stack.pop());
            if (!secondStr.equals("(")) {
                String leftStr = String.valueOf(stack.pop());
                String leftSign = String.valueOf(stack.pop());
                sb.append(leftSign);
                sb.append(leftStr);
            }
            sb.append(secondStr);
            sb.append(firstStr);
            sb.append(")");
            stack.push(sb.toString());

            while (stack.size() > 1 && num == 0) {
                StringBuffer sb2 = new StringBuffer();
                String rightStr2 = String.valueOf(stack.pop());
                String operate2 = String.valueOf(stack.pop());
                String leftStr2 = String.valueOf(stack.pop());
                if ((operate2.equals("|") || i == chars.length - 1) && stack.size() <= 1) {
                    sb2.append("(");
                }
                sb2.append(leftStr2);
                sb2.append(operate2);
                sb2.append(rightStr2);
                if ((operate2.equals("|") || i == chars.length - 1) && stack.size() <= 1) {
                    sb2.append(")");
                }
                stack.push(sb2.toString());
            }
        }
    }

    private static boolean isLeftSign(char c) {
        return Integer.valueOf(c) == 40;
    }

    private static boolean isRightSign(char c) {
        return Integer.valueOf(c) == 41;
    }

    private static boolean isLetter(char a) {
        return Integer.valueOf(a) >= 65 && Integer.valueOf(a) <= 90;
    }
}
