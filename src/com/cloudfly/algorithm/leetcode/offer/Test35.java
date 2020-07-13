package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.node.RandomNode;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Test35 {

    public static void main(String[] args) {
        RandomNode node1 = new RandomNode(7);
        RandomNode node2 = new RandomNode(13);
        RandomNode node3 = new RandomNode(11);
        RandomNode node4 = new RandomNode(10);
        RandomNode node5 = new RandomNode(1);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//
//        node1.random = null;
//        node2.random = node1;
//        node3.random = node5;
//        node4.random = node3;
//        node5.random = node1;

        node1.next = null;
        node1.random = null;

        System.out.println(copyRandomList(node1));
        System.out.println(node1);
    }

    public static RandomNode copyRandomList(RandomNode head) {
        if (head == null) {
            return null;
        }
        RandomNode node = head;
        RandomNode next = null;
        while (node != null) {
            RandomNode newNode = new RandomNode(node.val);
            next = node.next;
            node.next = newNode;
            newNode.next = next;
            node = next;
        }
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        RandomNode head1 = head;
        RandomNode head2 = head.next;
        node = head2;

        // 这一段把一个链表拆成两个写的有点,,,以后再想想
        while (node != null && node.next!=null) {
            head1.next = node.next;
            head1 = head1.next;
            node.next = node.next.next;
            node = node.next;
        }
        head1.next = null;
        return head2;
    }
}
