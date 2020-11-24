package com.cloudfly.algorithm.leetcode.normal;

import com.cloudfly.algorithm.leetcode.node.ListNode;

/**
 * 递归反转链表
 */
public class Test_1 {

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
        System.out.println(listNode1);
        ListNode reverse = new Test_1().reverse(listNode1);
        System.out.println(reverse);
    }

    public ListNode reverse(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }
        ListNode reverse = reverse(listNode.next);
        listNode.next.next = listNode;
        listNode.next = null;
        return reverse;
    }
}
