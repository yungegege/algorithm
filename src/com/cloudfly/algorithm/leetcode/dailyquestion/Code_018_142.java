package com.cloudfly.algorithm.leetcode.dailyquestion;

import com.cloudfly.algorithm.leetcode.node.ListNode;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 */
public class Code_018_142 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == head) {
                flag = true;
                break;
            }
        }
        if (!flag){
            return null;
        }
        while (head!=slow){
            head = head.next;
            slow = slow.next;
        }
        return slow;
    }
}
