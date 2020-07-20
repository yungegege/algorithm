package com.cloudfly.algorithm.leetcode.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Test57_2 {

    public static void main(String[] args) {
        int[][] arr1 = findContinuousSequence(9);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(Arrays.toString(arr1[i]));
        }
        int[][] arr2 = findContinuousSequence(15);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int len = target/ 2;
        for (int i = 1; i <= len; i += 1) {
            int sum = 0;
            int n = i;
            while (sum < target) {
                sum += n++;
            }
            int[] arr = new int[n - i];
            if (sum == target) {
                for (int j = i; j < n; j++) {
                    arr[j - i] = j;
                }
                list.add(arr);
                i+=1;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
