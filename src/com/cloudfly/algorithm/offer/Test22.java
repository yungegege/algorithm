package com.cloudfly.algorithm.offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:35
 */
public class Test22 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);
        root1.right.right.left = new TreeNode(8);
        root1.right.right.right = new TreeNode(9);
        System.out.println(new Test22().PrintFromTopToBottom(root1.right.right.right));
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root==null){
            return list;
        }
        ArrayList<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root);
        while (!treeNodeList.isEmpty()){
            if (treeNodeList.get(0).left!=null){
                treeNodeList.add(treeNodeList.get(0).left);
            }
            if (treeNodeList.get(0).right!=null){
                treeNodeList.add(treeNodeList.get(0).right);
            }
            list.add(treeNodeList.remove(0).val);
        }
        return list;
    }

    public ArrayList<Integer> PrintFromTopToBottom1(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        LinkedList<TreeNode> treeNodeList = new LinkedList<>();
        treeNodeList.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!treeNodeList.isEmpty()){
            TreeNode temp = treeNodeList.removeFirst();
            list.add(temp.val);
            if (temp.left!=null){
                treeNodeList.add(temp.left);
            }
            if (temp.right!=null){
                treeNodeList.add(temp.right);
            }
        }
        return list;
    }
}
