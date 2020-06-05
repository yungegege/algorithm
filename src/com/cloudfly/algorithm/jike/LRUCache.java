package com.cloudfly.algorithm.jike;

import java.util.HashMap;
import java.util.Map;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-05-29 15:33
 */
public class LRUCache {

    public LRUCache(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    private int initialCapacity;

    private int size = 0;

    private Map<String, ListNode> map = new HashMap<>();

    private ListNode head;
    private ListNode tail;

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(4);
        lruCache.put("a", 1);
        lruCache.put("b", 2);
        lruCache.put("c", 3);
        lruCache.put("d", 4);
        lruCache.get("a");
        lruCache.delete("c");
        lruCache.put("e", 5);
        lruCache.put("f", 6);
        lruCache.print();
    }

    public boolean put(String key, int value) {
        size++;
        ListNode listNode = new ListNode(key, value);
        if (head == null) {
            head = listNode;
            tail = listNode;
        } else {
            // 如果包含这个key,删除此节点
            if (map.containsKey(key)) {
                delete(key);
            } else if (size > initialCapacity) {
                // 如果容量达到限制,删除头结点
                delete(head.key);
            }
            // 把数据放入尾结点的next
            tail.next = listNode;
            listNode.pre = tail;
            tail = listNode;
        }
        map.put(key, listNode);
        return true;
    }

    public boolean delete(String key) {
        ListNode listNode = map.get(key);
        if (listNode == head) {
            head = listNode.next;
            listNode.pre = null;
        } else if (listNode == tail) {
            tail = listNode.pre;
            tail.next = null;
        } else {
            listNode.pre.next = listNode.next;
            listNode.next.pre = listNode.pre;
        }

        map.remove(key);
        size--;
        return true;
    }

    public Integer get(String key){
        ListNode listNode = map.get(key);
        if (listNode==null){
            return null;
        }
        put(key, listNode.value);
        return listNode.value;
    }

    public void print() {
        while (head != null) {
            System.out.print(head.key + ":" + head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    String key;
    int value;
    ListNode pre;
    ListNode next;

    public ListNode(String key, int value) {
        this.key = key;
        this.value = value;
    }

}


