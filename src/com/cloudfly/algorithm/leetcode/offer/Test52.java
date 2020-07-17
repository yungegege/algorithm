package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。(无环)
 */
public class Test52 {

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(4);
        ListNode nodeA2 = new ListNode(1);
        ListNode nodeA3 = new ListNode(8);
        ListNode nodeA4 = new ListNode(4);
        ListNode nodeA5 = new ListNode(5);
        ListNode nodeB1 = new ListNode(5);
        ListNode nodeB2 = new ListNode(0);
        ListNode nodeB3 = new ListNode(1);

        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        nodeA3.next = nodeA4;
        nodeA4.next = nodeA5;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
//        nodeB3.next = nodeA3;

        System.out.println(getIntersectionNode(nodeA1,nodeB1));
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode node = headA;
        int alen = 0;
        while (node != null) {
            node = node.next;
            alen++;
        }
        node = headB;
        int blen = 0;
        while (node != null) {
            node = node.next;
            blen++;
        }
        if (alen > blen) {
            for (int i = 0; i < alen - blen; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < blen - alen; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        if (headA == headB) {
            return headA;
        }
        return null;
    }
}
