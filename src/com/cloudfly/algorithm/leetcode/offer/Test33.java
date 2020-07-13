package com.cloudfly.algorithm.leetcode.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class Test33 {

    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 6, 3, 2, 5
        };
        int[] arr2 = new int[]{
                1, 3, 2, 6, 5
        };
        int[] arr3 = new int[]{
                5, 4, 3, 2, 1
        };
//        System.out.println(verifyPostorder(arr));
//        System.out.println(verifyPostorder(arr2));
        System.out.println(verifyPostorder(arr3));
    }

    public static boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2) {
            return true;
        }
        return digui(postorder, 0, postorder.length - 1);
    }

    private static boolean digui(int[] postorder, int L, int R) {
        if (L > R) {
            return true;
        }
        int val = postorder[R];
        boolean flag = false;
        int index = L;
        for (int i = L; i < R; i++) {
            if (!flag && postorder[i] > val) {
                index = i;
                flag = true;
            }
            if (flag && postorder[i] < val) {
                return false;
            }
        }
        return digui(postorder, L, index - 1) && digui(postorder, index, R - 1);
    }
}
