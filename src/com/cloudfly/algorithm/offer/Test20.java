package com.cloudfly.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:28
 */
public class Test20 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        Test20 test20 = new Test20();
        test20.push(3);
        System.out.println(test20.min());

        test20.push(4);
        System.out.println(test20.min());

        test20.push(2);
        System.out.println(test20.min());

        test20.push(3);
        System.out.println(test20.min());

        test20.pop();
        System.out.println(test20.min());

        test20.pop();
        System.out.println(test20.min());

        test20.pop();
        System.out.println(test20.min());

        test20.push(0);
        System.out.println(test20.min());
    }

    public void push(int node) {
        stack.push(node);
        if (minStack.size() == 0 || minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
