package com.cloudfly.algorithm.leetcode.twoweek.race31th;

import java.util.Stack;

public class Test4 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 1};
        int[] arr2 = {3, 1, 5, 4, 2};
//        System.out.println(minNumberOperations(arr1));
        System.out.println(minNumberOperations(arr2));
        System.out.println(minNumberOperations2(arr2));

    }

    /**
     * 单调栈解法  单调增
     */
    public static int minNumberOperations(int[] target) {
        Stack<Integer> stack = new Stack<>();
        stack.push(target[0]);
        int i = 1;
        int res = 0;
        while (i < target.length) {
            if (stack.peek() > target[i]) {
                res += (stack.peek() - target[i]);
                while (!stack.isEmpty() && stack.peek() > target[i]) {
                    stack.pop();
                }
            }
            stack.push(target[i++]);
        }
        return res+stack.peek();
    }

    /**
     * 找规律解法
     */
    public static int minNumberOperations2(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                res += (target[i] - target[i - 1]);
            }
        }
        return res;
    }

}
