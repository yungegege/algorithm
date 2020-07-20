package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 */
public class Test59_1 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,-1
//                1, 3, -1, -3, 5, 3, 6, 7
        };
        System.out.println(Arrays.toString(maxSlidingWindow(arr, 1)));
    }

    // 维持一个单调减的队列,存元素的下标
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && i - queue.peek() == k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[i]>nums[queue.peekLast()]){
                queue.pollLast();
            }
            queue.add(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[queue.peek()];
            }
        }
        return res;
    }
}
