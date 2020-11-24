package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.Stack;

public class Code_022_042 {

    public static void main(String[] args) {
        System.out.println(new Code_022_042().trap(new int[]{
                4,2,0,3,2,5
        }));
    }

    public int trap(int[] height) {
        // 单调递减
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i = 1;
        int res = 0;
        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pop = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int distance = i - stack.peek() - 1;
                int high = Math.min(height[i], height[stack.peek()]) - height[pop];
                res += distance * high;
            }
            stack.push(i++);
        }
        return res;
    }
}
