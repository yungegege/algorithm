package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.Arrays;

public class Code_004_130 {

    public static void main(String[] args) {
        char[][] arr = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        solve(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    public static void solve(char[][] board) {
        if (board.length < 3 || board[0].length < 3) {
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            // 第一行
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            // 最后一行
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; i++) {
            // 第一列
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            // 最后一列
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'Y';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
