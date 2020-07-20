package com.cloudfly.algorithm.leetcode.offer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Test61 {

    public static void main(String[] args) {
        int[] arr1 = new int[]{
                1, 2, 3, 4, 5
        };
        int[] arr2 = new int[]{
                0, 0, 1, 2, 5
        };
        System.out.println(isStraight(arr1));
        System.out.println(isStraight(arr2));
    }

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                num++;
            }else if (i<nums.length-1 && nums[i]==nums[i+1]){
                return false;
            }

        }
        return nums[4] - nums[num] < 5;
    }
}
