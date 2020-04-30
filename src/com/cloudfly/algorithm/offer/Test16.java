package com.cloudfly.algorithm.offer;

import com.sun.scenario.effect.Merge;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:27
 */
public class Test16 {

    public static void main(String[] args) {
        ListNode listNode_a_1 = new ListNode(1);
        ListNode listNode_a_2 = new ListNode(3);
        ListNode listNode_a_3 = new ListNode(5);
        ListNode listNode_a_4 = new ListNode(7);
        ListNode listNode_a_5 = new ListNode(9);
        listNode_a_1.next = listNode_a_2;
        listNode_a_2.next = listNode_a_3;
        listNode_a_3.next = listNode_a_4;
        listNode_a_4.next = listNode_a_5;
        listNode_a_5.next = null;
        ListNode listNode_b_1 = new ListNode(1);
        ListNode listNode_b_2 = new ListNode(5);
        ListNode listNode_b_3 = new ListNode(6);
        ListNode listNode_b_4 = new ListNode(8);
        listNode_b_1.next = listNode_b_2;
        listNode_b_2.next = listNode_b_3;
        listNode_b_3.next = listNode_b_4;
        listNode_b_4.next = null;
        System.out.println(new Test16().Merge(listNode_a_1,listNode_b_1));
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null && list2==null){
            return null;
        }
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        ListNode head = null;
        ListNode node = null;
        if (list1.val<=list2.val) {
            head = list1;
            list1 = list1.next;
        }else {
            head = list2;
            list2 = list2.next;
        }
        node = head;
        while (list1!=null && list2!=null){
            if (list1.val<=list2.val){
                node.next = list1;
                list1 = list1.next;
            }else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1!=null){
            node.next = list1;
        }else {
            node.next = list2;
        }
        return head;
    }
}
