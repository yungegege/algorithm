package com.cloudfly.algorithm.leetcode.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Test13 {

    public static void main(String[] args) {
//        System.out.println(shuweizhihe(8765));
        System.out.println(movingCount(1, 2, 1));
    }

    public static int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
        dfs(arr, 0, 0, k);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }

    // arr==1是访问过,但和大于k，等于2是
    private static void dfs(int[][] arr, int i, int j, int k) {

        // 越界
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
            return;
        }
        // 访问过
        if (arr[i][j] > 0){
            return;
        }
        arr[i][j] = 1;
        // 1代表访问过，但大于k
        if (shuweizhihe(i) + shuweizhihe(j) > k){
            arr[i][j] += 1;
            return;
        }
        // 下
        dfs(arr, i + 1, j, k);
        // 上
//        dfs(arr, i - 1, j, k);
        // 右
        dfs(arr, i, j + 1, k);
        // 左
//        dfs(arr, i, j - 1, k);
    }

    private static int shuweizhihe(int i) {
        int num = 0;
        while (i > 0) {
            num += i % 10;
            i /= 10;
        }
        return num;
    }


}
