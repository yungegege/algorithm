package com.cloudfly.algorithm.leetcode.offer;


import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.Arrays;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-07 14:45
 */
public class Test07 {

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
//        int[] preorder = new int[]{1, 2, 3};
//        int[] inorder = new int[]{3, 2, 1};
        TreeNode treeNode = buildTree(preorder, inorder);
        TreeNode treeNode2 = buildTree2(preorder, inorder);
        System.out.println(treeNode);
        System.out.println(treeNode2);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1),
                        Arrays.copyOfRange(inorder, 0, i));
                treeNode.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return treeNode;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        return digui(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode digui(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart >= preorder.length || inEnd < 0 || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                TreeNode treeNode = new TreeNode(preorder[preStart]);
                treeNode.left = digui(preorder, preStart + 1, preStart + i - inStart, inorder, inStart, i - 1);
                treeNode.right = digui(preorder, preStart + i - inStart + 1, preEnd, inorder, i + 1, inEnd);
                return treeNode;
            }
        }
        return null;
    }
}
