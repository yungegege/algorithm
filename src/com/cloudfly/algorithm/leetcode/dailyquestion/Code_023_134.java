package com.cloudfly.algorithm.leetcode.dailyquestion;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 */
public class Code_023_134 {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int num = 0;
        int sum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
            num = num + gas[i] - cost[i];
            if (num < 0) {
                num = 0;
                index = i + 1;
            }
        }
        return sum < 0 ? -1 : index;
    }
}
