package com.cloudfly.algorithm.leetcode.oneweek.race199th;

import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数 distance 。
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 * 返回树中 好叶子节点对的数量 。
 */
public class Test3 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);
        TreeNode treeNode11 = new TreeNode(11);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        treeNode4.right = treeNode8;
        treeNode5.right = treeNode9;
        treeNode6.right = treeNode10;
        treeNode9.right = treeNode11;
        Test3 test3 = new Test3();
        int i = test3.countPairs(treeNode1, 5);
        System.out.println(i);
    }

    List<List<TreeNode>> lists;

    public int countPairs(TreeNode root, int distance) {
        lists = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        digui(root, list);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
        int res = 0;
        for (int i = 0; i < lists.size(); i++) {
            List<TreeNode> curList = lists.get(i);
            for (int j = i + 1; j < lists.size(); j++) {
                List<TreeNode> otherList = lists.get(j);
                int count = curList.size() + otherList.size();
                int index = 0;
                while (index < Math.min(curList.size(), otherList.size()) && curList.get(index) == otherList.get(index)) {
                    index++;
                    count -= 2;
                }
                if (count <= distance) {
                    res += 1;
                }
            }
        }
        return res;
    }

    private void digui(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        if (root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
            list.remove(root);
            while (!list.isEmpty() && (list.get(list.size() - 1).right == null || list.get(list.size() - 1).right == root)) {
                root = list.get(list.size() - 1);
                list.remove(list.size() - 1);
            }
            return;
        }
        digui(root.left, list);
        digui(root.right, list);

    }
}
