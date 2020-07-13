package com.cloudfly.algorithm.leetcode.offer;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 */
public class Test12 {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'a', 'b', 'c', 'e' },
                {'s', 'f', 'c', 's' },
                {'a', 'd', 'e', 'e' }
        };
        System.out.println(exist(arr, "adbf"));
        System.out.println(exist(arr, "bfce"));
    }

    private static boolean flag = false;

    public static boolean exist(char[][] board, String word) {
        char[] strArr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 二维字符数组中的任何一个点 只要 等于字符串的第一个字符,就深度遍历看包不包含这个字符串
                if (board[i][j] == strArr[0] && dfs(board, i, j, strArr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, char[] strArr, int num) {
        // 不等于，终止递归
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || num >= strArr.length || board[i][j] != strArr[num]) {
            return false;
        }
        // 到最后一个，还相等
        if (num == strArr.length - 1) {
            return true;
        }
        // 标记一下这里走过了,题目要求一个字符只能走一次,并记录下数组的字符原本的值,遍历完还原回去
        char c = board[i][j];
        board[i][j] = '#';
        // 则判断四个方向是否相等
        boolean b = dfs(board, i + 1, j, strArr, num + 1) ||
                dfs(board, i - 1, j, strArr, num + 1) ||
                dfs(board, i, j + 1, strArr, num + 1) ||
                dfs(board, i, j - 1, strArr, num + 1);
        board[i][j] = c;
        return b;
    }
}
