package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

public class Code_032_543 {

    public static void main(String[] args) {

    }

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        digui(root);
        return max;
    }

    private int digui(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = digui(root.left);
        int right = digui(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
