package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Test28 {

    public static void main(String[] args) {
        TreeNode treeNodeA1 = new TreeNode(1);
        TreeNode treeNodeA2 = new TreeNode(2);
        TreeNode treeNodeA3 = new TreeNode(2);
        TreeNode treeNodeA4 = new TreeNode(3);
        TreeNode treeNodeA5 = new TreeNode(4);
        TreeNode treeNodeA6 = new TreeNode(4);
        TreeNode treeNodeA7 = new TreeNode(3);
        treeNodeA1.left = treeNodeA2;
        treeNodeA1.right = treeNodeA3;
        treeNodeA2.left = treeNodeA4;
        treeNodeA2.right = treeNodeA5;
        treeNodeA3.left = treeNodeA6;
        treeNodeA3.right = treeNodeA7;

        System.out.println(isSymmetric(treeNodeA1));
        System.out.println(treeNodeA1);

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return digui(root.left, root.right);
    }

    private static boolean digui(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && digui(left.left, right.right) && digui(left.right, right.left);
    }
}
