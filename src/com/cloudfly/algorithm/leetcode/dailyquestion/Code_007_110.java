package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class Code_007_110 {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return digui(root)>=0;
    }

    public int digui(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = digui(root.left);
        int right = digui(root.right);
        if(left<0 || right<0 || left-right>1 || right-left>1){
            return -1;
        }

        return Math.max(left,right)+1;
    }
}
