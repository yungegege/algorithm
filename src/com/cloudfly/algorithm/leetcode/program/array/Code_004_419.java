package com.cloudfly.algorithm.leetcode.program.array;

public class Code_004_419 {

    public static void main(String[] args) {

    }

    public static int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = false;
                if (board[i][j] == 'X') {
                    flag = true;
                    if (i > 0 && board[i - 1][j] == 'X' || j > 0 && board[i][j - 1] == 'X') {
                        flag = false;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
        return res;
    }
}
