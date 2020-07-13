package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Test26 {

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

        TreeNode treeNodeB1 = new TreeNode(2);
        TreeNode treeNodeB2 = new TreeNode(4);
        TreeNode treeNodeB3 = new TreeNode(5);
        treeNodeB1.left = treeNodeB2;
        treeNodeB1.right = treeNodeB3;

        System.out.println(isSubStructure(treeNodeA1, treeNodeB1));

    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return digui(A, B) || digui(A.left, B) || digui(A.right,B);
    }

    private static boolean digui(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return A.val == B.val && digui(A.left, B.left) && digui(A.right, B.right);
    }


}
