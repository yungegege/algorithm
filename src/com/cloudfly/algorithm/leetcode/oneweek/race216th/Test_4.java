package com.cloudfly.algorithm.leetcode.oneweek.race216th;

import java.util.Arrays;
import java.util.Comparator;

public class Test_4 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 51},
                {1, 51},
                {24, 25},
                {24, 25},

        };
        System.out.println(new Test_4().minimumEffort(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int a = o1[1] - o1[0];
                int b = o2[1] - o2[0];
                return a - b;
            }
        });
        int res = 0;
        for (int i = 0; i < tasks.length; i++) {
            res = Math.max(tasks[i][1], tasks[i][0] + res);
        }
        return res;
    }
}
