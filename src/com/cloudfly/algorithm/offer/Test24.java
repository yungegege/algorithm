package com.cloudfly.algorithm.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-18 11:33
 */
public class Test24 {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath1(root.left, target);
        FindPath1(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }

    public static void main(String[] args) {
        //        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        ArrayList<ArrayList<Integer>> arrayLists = new Test24().FindPath(root, 4);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(2);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(1);
        root.right.right.left = new TreeNode(2);
        root.right.right.left.left = new TreeNode(1);
        ArrayList<ArrayList<Integer>> arrayList1 = new Test24().FindPath1(root, 9);
        Collections.sort(arrayList1, (a, b) -> b.size() - a.size());
        for (ArrayList<Integer> list : arrayList1) {
            System.out.println(list);
        }
        System.out.println("-------------------------------------");

        ArrayList<ArrayList<Integer>> arrayList2 = new Test24().FindPath2(root, 9);
        Collections.sort(arrayList1, (a, b) -> a.size() - b.size());
        for (ArrayList<Integer> list : arrayList2) {
            System.out.println(list);
        }
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
        if (root == null) {
            return bigList;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (root.val == target && root.left == null && root.right == null) {
            list.add(root.val);
            bigList.add(list);
            return bigList;
        }
        if (root.left != null) {
            ArrayList<ArrayList<Integer>> leftList = FindPath(root.left, target - root.val);
            for (ArrayList<Integer> item : leftList) {
                item.add(0, root.val);
            }
            bigList.addAll(leftList);
        }
        if (root.right != null) {
            ArrayList<ArrayList<Integer>> rightList = FindPath(root.right, target - root.val);
            for (ArrayList<Integer> item : rightList) {
                item.add(0, root.val);
            }
            bigList.addAll(rightList);
        }
        return bigList;
    }

    public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
        find(bigList, new ArrayList<>(), root, target);
        return bigList;
    }

    public void find(ArrayList<ArrayList<Integer>> bigList, ArrayList<Integer> list, TreeNode root, int target) {
        list.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            bigList.add(list);
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        if (root.left != null) {
            find(bigList, list, root.left, target - root.val);
        }
        if (root.right != null) {
            find(bigList, list1, root.right, target - root.val);
        }
    }
}
