package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Test25 {

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(1);
        ListNode nodeA2 = new ListNode(2);
        ListNode nodeA3 = new ListNode(4);
        ListNode nodeB1 = new ListNode(1);
        ListNode nodeB2 = new ListNode(3);
        ListNode nodeB3 = new ListNode(4);
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        System.out.println(mergeTwoLists(nodeA1, nodeB1));
    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                node.next = A;
                A = A.next;
            } else {
                node.next = B;
                B = B.next;
            }
            node = node.next;
        }
        if (A != null) {
            node.next = A;
        }

        if (B != null) {
            node.next = B;
        }
        return head.next;


    }
}
