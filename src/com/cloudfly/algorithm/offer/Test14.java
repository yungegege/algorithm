package com.cloudfly.algorithm.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 11:25
 */
public class Test14 {
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
        System.out.println(new Test14().FindKthToTail(listNode1,5));
    }

    /**
     * 第一遍遍历出节点总个数n,第二遍找到第n-k+1个节点,如共7个节点，倒数第5个就是第3个
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode node = head;
        int n = 0;
        while (node!=null){
            n++;
            node = node.next;
        }
        for (int i = 0; i < n - k + 1; i++) {
            head = head.next;
        }
        return head;
    }
}
