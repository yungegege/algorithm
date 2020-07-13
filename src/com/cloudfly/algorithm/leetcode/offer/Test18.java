package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.ListNode;

/**
 * 一次通过 ！！！ 可喜可贺！！！
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Test18 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        System.out.println(deleteNode(listNode1,5));
        System.out.println(deleteNode(listNode1,2));
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head==null){
            return null;
        }
        // 如果是头结点，直接返回下一个节点
        if (head.val==val){
            return head.next;
        }
        ListNode pre = head;
        while (pre.next!=null){
            // 找到节点后break,此时pre只想要删除节点的前一个节点
            if (pre.next.val==val){
                pre.next = pre.next.next;
                return head;
            }
            pre = pre.next;
        }
        return head;
    }
}
