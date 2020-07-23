package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.Stack;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class Test37 {

    public static void main(String[] args) {
        TreeNode treeNodeA1 = new TreeNode(1);
        TreeNode treeNodeA2 = new TreeNode(2);
        TreeNode treeNodeA3 = new TreeNode(3);
        TreeNode treeNodeA4 = new TreeNode(4);
        TreeNode treeNodeA5 = new TreeNode(5);
        TreeNode treeNodeA6 = new TreeNode(6);
        TreeNode treeNodeA7 = new TreeNode(7);
        TreeNode treeNodeA8 = new TreeNode(8);
        TreeNode treeNodeA9 = new TreeNode(9);
        treeNodeA1.left = treeNodeA2;
        treeNodeA1.right = treeNodeA3;
        treeNodeA2.left = treeNodeA4;
        treeNodeA2.right = treeNodeA5;
        treeNodeA3.left = treeNodeA6;
        treeNodeA5.left = treeNodeA7;
        treeNodeA5.right = treeNodeA8;
        treeNodeA6.right = treeNodeA9;

        Test37 test37 = new Test37();
        String str = test37.serialize(treeNodeA1);
        System.out.println(str);
        TreeNode node = test37.deserialize(str);
        System.out.println(node);
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
            sb.append("_");
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data==null){
            return null;
        }
        String[] arr = data.substring(0, data.length() - 1).split("_");
        TreeNode res = null;
        int i = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(new TreeNode(Integer.parseInt(arr[i++])));
        while (i < arr.length && !stack.isEmpty()) {
            while (!"null".equals(arr[i])) {
                TreeNode newNode = new TreeNode(Integer.parseInt(arr[i++]));
                stack.peek().left = newNode;
                stack.push(newNode);
            }
            if (i < arr.length && "null".equals(arr[i])) {
                stack.peek().left = null;
                i++;
            }
            while (i < arr.length && "null".equals(arr[i])) {
                TreeNode pop = stack.pop();
                res = pop;
                i++;
                while (!stack.isEmpty() && stack.peek().right!=null){
                    res = stack.pop();
                }
            }

            if (i < arr.length) {
                TreeNode node = new TreeNode(Integer.parseInt(arr[i++]));
                stack.peek().right = node;
                stack.push(node);
            }
        }
        return res;
    }
}
