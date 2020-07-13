package com.cloudfly.algorithm.leetcode.offer;

import com.cloudfly.algorithm.leetcode.offer.node.ListNode;

import java.util.Arrays;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-07-07 14:45
 */
public class Test06 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2};
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        System.out.println(Arrays.toString(reversePrint(node1)));
    }

    /**
     * 用的递归
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        int[] arr = new int[len];
        // 这里可以把数字从右到左放入数组,
        // 但感觉有点简单,所以用的递归,虽然变复杂了，但有点练习效果
        digui(head, arr, len-1);
        return arr;
    }

    private static void digui(ListNode head, int[] arr, int len) {
        if (head == null) {
            return;
        }
        digui(head.next, arr,len-1);
        arr[len] = head.val;
    }
}

