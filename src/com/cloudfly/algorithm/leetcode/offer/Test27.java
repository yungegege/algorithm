package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Test27 {

    public static void main(String[] args) {
        TreeNode treeNodeA1 = new TreeNode(1);
        TreeNode treeNodeA2 = new TreeNode(2);
        TreeNode treeNodeA3 = new TreeNode(3);
        TreeNode treeNodeA4 = new TreeNode(4);
        TreeNode treeNodeA5 = new TreeNode(5);
        treeNodeA1.left = treeNodeA2;
        treeNodeA1.right = treeNodeA3;
        treeNodeA2.left = treeNodeA4;
        treeNodeA2.right = treeNodeA5;

        System.out.println(mirrorTree(treeNodeA1));
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        if (root.left!=null){
            mirrorTree(root.left);
        }
        if (root.right!=null){
            mirrorTree(root.right);
        }
        return root;
    }

}
