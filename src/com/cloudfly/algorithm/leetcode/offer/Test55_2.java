package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class Test55_2 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode5.left = treeNode6;

        System.out.println(isBalanced(treeNode1));
    }

    public static boolean isBalanced(TreeNode root) {
        int[] arr = digui(root);
        return arr[1] == 0;
    }

    /**
     * int[] 俩元素，第一个存高度，第二个存0(是平衡二叉树)、1(不是平衡二叉树)
     */
    private static int[] digui(TreeNode root) {
        int[] arr = new int[2];
        if (root == null) {
            // 高度0,是平衡二叉树
            return new int[]{0, 0};
        }
        int[] leftArr = digui(root.left);
        int[] rightArr = digui(root.right);
        arr[0] = Math.max(leftArr[0], rightArr[0]) + 1;
        if (Math.abs(leftArr[0] - rightArr[0]) > 1 || leftArr[1] == 1 || rightArr[1] == 1) {
            arr[1] = 1;
        }
        return arr;
    }
}
