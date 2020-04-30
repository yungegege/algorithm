package com.cloudfly.algorithm.offer;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:28
 */
public class Test18 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        System.out.println(root);
        new Test18().Mirror(root);
        System.out.println(root);
    }

    public void Mirror(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
