package com.cloudfly.algorithm.offer;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-24 18:37
 */
public class Test4 {

    public static void main(String[] args) {
        System.out.println(new Test4().reConstructBinaryTree(
                new int[]{
                        4,7,2,1,5,3,8,6
                },
                new int[]{
                        4,7,2,1,5,3,8,6
                }));

    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode treeNode = null;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == (in[i])){
                treeNode = new TreeNode(pre[0]);
                treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),
                        Arrays.copyOfRange(in,0,i));
                treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),
                        Arrays.copyOfRange(in,i+1,pre.length));
                break;
            }
        }

        return treeNode;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
