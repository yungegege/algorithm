package com.cloudfly.algorithm.leetcode.offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-07 14:46
 */
public class Test08 {
    public static void main(String[] args) {
    }

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public Test08() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        if (stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }

}
