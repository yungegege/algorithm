package com.cloudfly.algorithm.offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:26
 */
public class Test15 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = null;
        System.out.println(new Test15().ReverseList(listNode1));
    }

    /**
     * 就是瞎几把改指针 1->2->3->4->5->6->7->null
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode node = null;
        ListNode next;
        while (head!=null){
            next = head.next;
            head.next = node;
            node = head;
            head = next;

        }
        return node;
    }
}
