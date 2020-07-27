package com.cloudfly.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-27 16:19
 */
public class Code_001_217 {
    public static void main(String[] args) {
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
