package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.*;

public class Test32_3 {

    public static void main(String[] args) {
        TreeNode treeNodeA1 = new TreeNode(1);
        TreeNode treeNodeA2 = new TreeNode(2);
        TreeNode treeNodeA3 = new TreeNode(3);
        TreeNode treeNodeA4 = new TreeNode(4);
        TreeNode treeNodeA5 = new TreeNode(5);
        TreeNode treeNodeA6 = new TreeNode(6);
        TreeNode treeNodeA7 = new TreeNode(7);
        treeNodeA1.left = treeNodeA2;
        treeNodeA1.right = treeNodeA3;
        treeNodeA2.left = treeNodeA4;
        treeNodeA2.right = treeNodeA5;
        treeNodeA3.left = treeNodeA6;
        treeNodeA3.right = treeNodeA7;

        System.out.println(levelOrder(treeNodeA1));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bigList = new ArrayList<>();
        if (root == null) {
            return bigList;
        }
        Queue<TreeNode> aStack = new LinkedList<>();
        aStack.add(root);
        int size = aStack.size();
        boolean flag = true;
        while (!aStack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node;
                node = aStack.poll();
                if (flag) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) {
                    aStack.add(node.left);
                }
                if (node.right != null) {
                    aStack.add(node.right);
                }
            }
            flag = !flag;
            bigList.add(list);
            size = aStack.size();
        }
        return bigList;
    }
}
