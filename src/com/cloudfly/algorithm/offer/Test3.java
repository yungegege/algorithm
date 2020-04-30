package com.cloudfly.algorithm.offer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-23 11:28
 */
public class Test3 {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (null==listNode){
            return new ArrayList<>();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode next = listNode;
        ListNode pre = null;
        while (next!=null){
            next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        while (pre!=null){
            arrayList.add(pre.val);
            pre = pre.next;
        }
        return arrayList;
    }

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
        listNode5.next = null;
        Test3 test3 = new Test3();
        ArrayList<Integer> arrayList = test3.printListFromTailToHead(null);
        System.out.println(arrayList);

    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
        return val+" "+next;
    }
}
