package com.cloudfly.algorithm.leetcode.normal;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 二叉树两个节点最近公共祖先
 */
public class Test_2 {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        } else if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }


}
