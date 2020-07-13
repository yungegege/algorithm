package com.cloudfly.algorithm.leetcode.node;

public class RandomNode {
    public int val;
    public RandomNode next;
    public RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        return "RandomNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
