package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class Test34 {

    public static void main(String[] args) {
        TreeNode treeNodeA1 = new TreeNode(5);
        TreeNode treeNodeA2 = new TreeNode(4);
        TreeNode treeNodeA3 = new TreeNode(8);
        TreeNode treeNodeA4 = new TreeNode(11);
        TreeNode treeNodeA5 = new TreeNode(13);
        TreeNode treeNodeA6 = new TreeNode(4);
        TreeNode treeNodeA7 = new TreeNode(7);
        TreeNode treeNodeA8 = new TreeNode(2);
        TreeNode treeNodeA9 = new TreeNode(5);
        TreeNode treeNodeA10 = new TreeNode(1);
        treeNodeA1.left = treeNodeA2;
        treeNodeA1.right = treeNodeA3;
        treeNodeA2.left = treeNodeA4;
        treeNodeA3.left = treeNodeA5;
        treeNodeA3.right = treeNodeA6;
        treeNodeA4.left = treeNodeA7;
        treeNodeA4.right = treeNodeA8;
        treeNodeA6.left = treeNodeA9;
        treeNodeA6.right = treeNodeA10;
        System.out.println(pathSum(treeNodeA1, 22));
        System.out.println(pathSum2(treeNodeA1, 22));
    }

    private static List<List<Integer>> res;

    public static List<List<Integer>> pathSum2(TreeNode root, int sum) {
        res = new ArrayList<>();
        digui(root, new ArrayList<>(), sum);
        return res;
    }

    private static void digui(TreeNode root, List<Integer> list, int sum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(list));
        }else {
            digui(root.left, list, sum - root.val);
            digui(root.right, list, sum - root.val);
        }
        list.remove(list.size()-1);

    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> bigList = new ArrayList<>();
        if (root == null) {
            return bigList;
        }
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                bigList.add(list);
            }
            return bigList;

        }
        if (root.left != null) {
            List<List<Integer>> leftList = pathSum(root.left, sum - root.val);
            for (List<Integer> list : leftList) {
                list.add(0, root.val);
            }
            bigList.addAll(leftList);
        }
        if (root.right != null) {
            List<List<Integer>> rightList = pathSum(root.right, sum - root.val);
            for (List<Integer> list : rightList) {
                list.add(0, root.val);
            }
            bigList.addAll(rightList);
        }
        return bigList;
    }
}
