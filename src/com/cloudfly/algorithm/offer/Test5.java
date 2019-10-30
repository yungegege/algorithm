package com.cloudfly.algorithm.offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-24 18:38
 */
public class Test5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack1.empty()){
            return -1;
        }
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int a = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return a;
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        test5.push(1);
        test5.push(2);
        test5.push(3);
        System.out.println(test5.pop());
        test5.push(4);
        System.out.println(test5.pop());
        System.out.println(test5.pop());
        System.out.println(test5.pop());
        System.out.println(test5.pop());
    }
}
