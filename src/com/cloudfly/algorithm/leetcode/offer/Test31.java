package com.cloudfly.algorithm.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class Test31 {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped1 = {4,5,3,2};
        int[] popped2 = {4, 3, 5, 1, 2};

        System.out.println(validateStackSequences(pushed, popped1));
        System.out.println(validateStackSequences(pushed, popped2));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int i = 0;
        int j = 0;
        Deque<Integer> aStack = new ArrayDeque<>();
        while (i < pushed.length) {
            aStack.push(pushed[i]);
            for (int k = j; k < popped.length; k++) {
                // 栈不为空，且栈顶元素等于k位置元素
                if (!aStack.isEmpty() && popped[k] == aStack.peek()) {
                    aStack.pop();
                    j++;
                }else {
                    break;
                }
            }
            i++;
        }
        return aStack.isEmpty();
    }
}
