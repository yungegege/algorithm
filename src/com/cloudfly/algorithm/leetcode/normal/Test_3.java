package com.cloudfly.algorithm.leetcode.normal;

import java.util.Stack;

/**
 * 双栈实现队列
 */
public class Test_3 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        Test_3 test_3 = new Test_3();
        test_3.push(1);
        test_3.push(2);
        System.out.println(test_3.pop());
        test_3.push(3);
        test_3.push(4);
        test_3.push(5);
        System.out.println(test_3.pop());
        test_3.push(6);
        System.out.println(test_3.pop());
        System.out.println(test_3.pop());
        System.out.println(test_3.pop());
        System.out.println(test_3.pop());
    }

    public void push(int n) {
        stack1.push(n);
    }

    public int pop() {
        while (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
