package com.cloudfly.algorithm.offer;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:28
 */
public class Test17 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
//        root1.right.left = new TreeNode(6);
//        root1.right.right = new TreeNode(7);
//        root1.right.right.right = new TreeNode(8);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
//        root2.right.right = new TreeNode(8);
        System.out.println(root1);
        System.out.println(root2);
        System.out.println(new Test17().HasSubtree(root1, root2));
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1==null || root2==null){
            return false;
        }
        return aaa(root1,root2) || aaa(root1.left,root2) || aaa(root1.right,root2);
    }

    public boolean aaa(TreeNode root1, TreeNode root2) {
        if (root2==null){
            return true;
        }
        if (root1==null){
            return false;
        }
        if (root2.val!=root1.val){
            return aaa(root1.left,root2) || aaa(root1.right,root2);
        }
        return aaa(root1.left,root2.left) && aaa(root1.right,root2.right);
    }
}
