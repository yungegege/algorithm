package com.cloudfly.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Code_004_207 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 0}
        };
        System.out.println(canFinish(2, arr));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] arr = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (arr[prerequisites[i][0]] == null) {
                arr[prerequisites[i][0]] = new ArrayList<>();
            }
            arr[prerequisites[i][0]].add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = numCourses;
        while (!queue.isEmpty()) {
            count--;
            int n = queue.poll();
            List<Integer> list = arr[n];
            if (list == null) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                inDegree[list.get(i)]--;
                if (inDegree[list.get(i)] == 0) {
                    queue.add(list.get(i));
                }
            }
        }
        return count == 0;
    }
}
