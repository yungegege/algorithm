package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.*;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * 示例 1：
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 * <p>
 * 提示：
 * 节点值的范围在32位有符号整数范围内。
 */
public class Code_015_637 {

    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int len = 1;
        while (!queue.isEmpty()) {
            double sum = 0;
            int newLen = 0;
            for (int i = 0; i < len; i++) {
                TreeNode treeNode = queue.poll();
                sum += treeNode.val;
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                    newLen++;
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                    newLen++;
                }
            }
            list.add(sum / len);
            len = newLen;
        }
        return list;
    }
}
