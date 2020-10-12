package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class Code_017_113 {

    public static void main(String[] args) {

    }


    List<List<Integer>> lists;
    List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        lists = new ArrayList<>();
        list = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        digui(root, sum);
        return lists;
    }

    private void digui(TreeNode root, int sum) {
        if (root ==null) {
            return;
        }
        if (root.val==sum) {
            list.add(root.val);
            lists.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        digui(root.left, sum - root.val);
        digui(root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}
