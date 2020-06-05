package com.cloudfly.algorithm.jike.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表存储无向图
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-06-01 09:56
 */
public class Graph {

    private int v;

    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    /**
     * 广度遍历
     */
    public void bfs(int a, int b) {
        if (a == b) {
            return;
        }
        int[] pre = new int[v];
        boolean[] visit = new boolean[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        while (queue.size() > 0) {
            Integer val = queue.poll();
            for (int i = 0; i < adj[val].size(); i++) {
                int q = adj[val].get(i);
                if (!visit[q]) {
                    pre[q] = val;
                    if (q == b) {
                        print(pre, a, b);
                        return;
                    }
                    queue.add(q);
                    visit[q] = true;
                }
            }
        }
    }

    private void print(int[] pre, int a, int b) {
        if (a != b && pre[b] != -1) {
            print(pre, a, pre[b]);
            System.out.print(" -> ");
        }
        System.out.print(b);
    }

    /**
     * 深度优先遍历
     */
    public void dfs(){

    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.add(0, 1);
        graph.add(1, 2);
        graph.add(2, 3);
        graph.add(3, 4);
        graph.add(0, 4);
//        graph.add(0, 3);
//        graph.add(0, 3);
//        graph.add(0, 3);
//        graph.add(0, 3);
//        graph.add(0, 3);
//        graph.add(0, 3);
//        graph.add(0, 3);
//        graph.add(0, 3);
//        graph.add(0, 3);

        graph.bfs(0, 4);
    }


}
