package com.cloudfly.algorithm.nowcoder.junior.class_1;

import java.util.LinkedHashMap;

/**
 * 单链表快拍
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-05-29 10:28
 */
public class Code_05_LinkedListQuickSort {

    public static void main(String[] args) {
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(7);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(9);
        Node node7 = new Node(4);
        Node node8 = new Node(8);
        Node node9 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;
        Node head = node1;
        System.out.println("排序前：");
        printLinkedList(head);

        mergeSort(node1, node9);

        head = node1;
        System.out.println("排序后：");
        printLinkedList(head);

    }

    /**
     * 链表快排
     *
     * @param head
     */
    private static void mergeSort(Node head, Node tail) {
        if (head == null) {
            return;
        }

    }


    private static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}


class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
