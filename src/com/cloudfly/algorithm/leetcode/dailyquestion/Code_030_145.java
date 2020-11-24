package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.*;

public class Code_030_145 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.left = treeNode3;
        Code_030_145 object = new Code_030_145();
        System.out.println(object.levelOrder(treeNode1));
//        System.out.println(object.preOrderTraversal(treeNode1));
//        System.out.println(object.inOrderTraversal(treeNode1));
//        System.out.println(object.postOrderTraversal(treeNode1));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        int a = 1;
        int b = 0;
        while (!queue.isEmpty()) {
            TreeNode pop = queue.poll();
            list.add(pop.val);
            if (pop.left != null) {
                b++;
                queue.add(pop.left);
            }
            if (pop.right != null) {
                b++;
                queue.add(pop.right);
            }
            a--;
            if (a == 0) {
                a = b;
                b = 0;
                lists.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return lists;
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return list;
    }

    public List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return list;
    }

    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                list.add(0, root.val);
                root = root.right;
            }
            root = stack.pop().left;
        }
        return list;
    }

    public List<Integer> postOrderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                list.add(0, node.val);
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return list;
    }
}
