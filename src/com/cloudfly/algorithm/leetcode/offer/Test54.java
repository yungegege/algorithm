package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Test54 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(4);
        TreeNode treeNode6 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode4.left = treeNode6;

        System.out.println(kthLargest(treeNode1, 3));
    }

    private static int n;
    private static int res;

    public static int kthLargest(TreeNode root, int k) {
        n = k;
        digui(root);
        return res;
    }

    private static void digui(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            digui(root.right);
        }
        if (--n == 0) {
            res = root.val;
        }
        if (root.left != null) {
            digui(root.left);
        }

    }
}
