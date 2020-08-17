package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.*;

/**
 * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 *
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *  
 */
public class Code_005_133 {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors = new ArrayList<>();
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node node = cloneGraph(node1);
        System.out.println(node);
    }

    public static Node cloneGraph(Node node) {
        if (node==null){
            return null;
        }
        Node newNode = new Node(node.val);
        Map<Integer,Node> map1 = new HashMap<>();
        Map<Integer,Node> map2 = new HashMap<>();
        map1.put(node.val,node);
        map2.put(newNode.val,newNode);
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.add(node);
        queue2.add(newNode);
        while(!queue1.isEmpty()){
            Node node1 = queue1.poll();
            Node node2 = queue2.poll();
            node2.neighbors = new ArrayList<>();
            boolean flag = false;
            for(Node sun: node1.neighbors){
                Node temp;
                if (map2.containsKey(sun.val)){
                    temp = map2.get(sun.val);
                }else {
                    temp = new Node(sun.val);
                }
                node2.neighbors.add(temp);
                if(!map1.containsKey(sun.val)){
                    map1.put(sun.val,sun);
                    map2.put(temp.val,temp);
                    queue1.add(sun);
                    queue2.add(temp);
                    flag = true;
                }

            }
            if(!flag){
                break;
            }
        }
        return newNode;
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
