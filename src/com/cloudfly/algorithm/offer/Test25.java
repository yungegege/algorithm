package com.cloudfly.algorithm.offer;

import java.util.ArrayList;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-18 11:34
 */
public class Test25 {

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node2.random = node4;
        node3.random = node5;
        node4.random = node1;
        node5.random = node2;
        RandomListNode clone = new Test25().Clone(node1);
        while (clone != null) {
            System.out.println(clone);
            clone = clone.next;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ArrayList<RandomListNode> listNodes = new ArrayList<>();
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode listNode = new RandomListNode(node.label);
            listNodes.add(listNode);
            node = node.next;
        }
        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
            listNodes.get(i).random = pHead.random;
            pHead = pHead.next;
        }
        return listNodes.get(0);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        String nextValue =  next== null ? "null" : String.valueOf(next.label);
        String randomValue =  next== null ? "null" : String.valueOf(random.label);
        return "RandomListNode{" +
                "label=" + label +
                ", next=" + nextValue +
                ", random=" + randomValue+
                '}';
    }
}
