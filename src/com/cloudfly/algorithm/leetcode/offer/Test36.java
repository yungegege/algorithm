package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class Test36 {

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(1);
        Node node5 = new Node(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        Node node = treeToDoublyList(node1);

        int val = node.val;
        while (node.right.val!=val){
            System.out.print(node.val+" > ");
            node = node.right;
        }
        System.out.println(node.val);
    }

    public static Node treeToDoublyList(Node root) {
        List<Node> list = new ArrayList<>();
        digui(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(list.size() - 1).right = list.get(0);
                list.get(0).left = list.get(list.size() - 1);
            } else {
                list.get(i).right = list.get(i + 1);
                list.get(i + 1).left = list.get(i);
            }
        }
        return list.isEmpty() ? null : list.get(0);
    }

    private static void digui(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        digui(root.left, list);
        list.add(root);
        digui(root.right, list);
    }
}
