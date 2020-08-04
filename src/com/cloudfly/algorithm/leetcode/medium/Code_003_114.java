package com.cloudfly.algorithm.leetcode.medium;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 */
public class Code_003_114 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        flatten(node1);
        System.out.println(node1);

    }

    public static void flatten(TreeNode root) {
        TreeNode temp = root;
        TreeNode node = null;
        while (temp!=null){
            if (temp.left!=null){
                node = temp.left;
                while (node.right!=null){
                    node = node.right;
                }
                node.right = temp.right;
                temp.right = temp.left;
                temp.left = null;
            }
            temp = temp.right;

        }
    }
}
