package com.cloudfly.algorithm.leetcode.offer.node;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-07 15:44
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
