package com.cloudfly.algorithm.leetcode.dailyquestion;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * <p>
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class Code_033_581 {
    public static void main(String[] args) {
        System.out.println(new Code_033_581().findUnsortedSubarray(new int[]{
                1,3,2,3,3
        }));
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] leftMax = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            leftMax[i] = max;
        }
        int[] rightMin = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = nums.length-1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            rightMin[i] = min;
        }
        int leftIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i+1<nums.length && nums[i]<=rightMin[i+1]){
                leftIndex++;
            }else {
                break;
            }
        }
        if (leftIndex==nums.length-2){
            return 0;
        }
        int rightIndex = nums.length;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (i>0 && nums[i]>=leftMax[i-1]){
                rightIndex--;
            }else {
                break;
            }
        }
        return rightIndex-leftIndex+1;
    }
}
