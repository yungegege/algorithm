package com.cloudfly.algorithm.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class Test30 {

    public static void main(String[] args) {
        Test30 test30 = new Test30();
        test30.min();
        test30.push(-1);
        System.out.println(test30.top());
        System.out.println(test30.min());

    }

    private Deque<Integer> dataStack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int num = dataStack.pop();
        if (num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
