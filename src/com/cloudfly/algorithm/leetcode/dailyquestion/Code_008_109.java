package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.ListNode;
import com.cloudfly.algorithm.leetcode.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class Code_008_109 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Code_008_109 code_008_109 = new Code_008_109();
        System.out.println(code_008_109.sortedListToBST2(listNode1));
    }

    ListNode globalHead;

    public TreeNode sortedListToBST2(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        return digui(list,0,list.size()-1);
    }

    private TreeNode digui(List<ListNode> list,int l,int r){
        if(l>r){
            return null;
        }
        int mid = l+(r-l)/2;
        TreeNode treeNode = new TreeNode(list.get(mid).val);
        treeNode.left = digui(list,l,mid-1);
        treeNode.right = digui(list,mid+1,r);
        return treeNode;
    }
}
