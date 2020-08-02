package com.cloudfly.algorithm.leetcode.gaopin;

import com.cloudfly.algorithm.leetcode.node.ListNode;

public class Code_002_002 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        System.out.println(addTwoNumbers(node1,node4));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val;
        int jinwei = 0;
        ListNode head = new ListNode(-1);
        ListNode a = head;
        while (l1 != null && l2 != null) {
            val = (l1.val + l2.val + jinwei) % 10;
            jinwei = (l1.val + l2.val + jinwei) / 10;
            a.next = new ListNode(val);
            a = a.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode temp = null;
        if (l1!=null){
            temp = l1;
        }
        if (l2!=null){
            temp = l2;
        }
        while (temp != null) {
            val = (temp.val + jinwei) % 10;
            jinwei = (temp.val + jinwei) / 10;
            a.next = new ListNode(val);
            a = a.next;
            temp = temp.next;
        }
        if (jinwei!=0){
            a.next = new ListNode(jinwei);
        }
        return head.next;
    }
}
