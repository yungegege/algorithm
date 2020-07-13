package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 */
public class Test22 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(getKthFromEnd(null, 2));
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        // 节点个数
        int num = 0;
        ListNode node = head;
        while (node != null) {
            num++;
            node = node.next;
        }
        for (int i = 0; i < num - k; i++) {
            head = head.next;
            if (head==null){
                return null;
            }
        }
        return head;

    }

}
