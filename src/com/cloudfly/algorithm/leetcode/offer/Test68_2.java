package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class Test68_2 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(2);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(8);
        TreeNode treeNode8 = new TreeNode(7);
        TreeNode treeNode9 = new TreeNode(4);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode5.left = treeNode8;
        treeNode5.right = treeNode9;

        System.out.println(lowestCommonAncestor(treeNode1, treeNode2, treeNode3));
        System.out.println(lowestCommonAncestor(treeNode1, treeNode4, treeNode9));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        return root;
    }

    private static int otherVal;
    private static boolean flag;

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        flag = false;
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        map.put(root, 1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            // 找到第一个值
            if (!flag && (node.val == p.val || node.val == q.val)) {
                flag = true;
                if (node.val == p.val) {
                    otherVal = q.val;
                } else {
                    otherVal = p.val;
                }
                while (!stack.isEmpty()) {
                    TreeNode pop = stack.pop();
                    map.put(pop, 2);
                    stack2.push(pop);
                }
                while (!stack2.isEmpty()) {
                    stack.push(stack2.pop());
                }
            }
            // 找到第二个值
            if (flag && node.val == otherVal) {
                while (!stack.isEmpty()) {
                    TreeNode pop = stack.pop();
                    if (map.get(pop) != null && map.get(pop) == 2) {
                        return pop;
                    }
                }
            }
            if ((map.get(node.left) != null || node.left == null) && (map.get(node.right) != null || node.right == null)) {
                stack.pop();
            }
            // 左孩子已经遍历过或者左孩子为空 并且右孩子不为空,则有孩子入栈
            if ((map.get(node.left) != null || node.left == null) && node.right != null) {
                stack.push(node.right);
                map.put(node.right, 1);
            }
            // 左孩子没有遍历过并且左孩子不为空，左孩子入栈
            if (map.get(node.left) == null && node.left != null) {
                stack.push(node.left);
                map.put(node.left, 1);
            }
        }
        return null;
    }
}
