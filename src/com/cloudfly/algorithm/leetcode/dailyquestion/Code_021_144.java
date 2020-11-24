package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.*;

public class Code_021_144 {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> counter = new HashMap<>();
        for (int elem : arr)
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);

        return counter.size() == new HashSet<Integer>(counter.values()).size();
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        System.out.println(new Code_021_144().preorderTraversal(treeNode1));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root==null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node = root;
        while(!stack.isEmpty()){
            if (node!=null){
                stack.push(node);
                list.add(node.val);
                node = node.left;
            }else {
                node = stack.pop().right;
            }
        }
        return list;
    }
}
