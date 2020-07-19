package com.cloudfly.algorithm.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class Test59_2 {

    public static void main(String[] args) {

        Test59_2 test59_2 = new Test59_2();
        test59_2.push_back(1);
        test59_2.push_back(5);
        test59_2.push_back(3);
        test59_2.push_back(2);
        test59_2.push_back(4);
        System.out.println(test59_2.max_value());
    }

    public Test59_2() {

    }

    private Deque<Integer> queue = new ArrayDeque<>();
    private Deque<Integer> maxQueue = new ArrayDeque<>();

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peek();
    }

    public void push_back(int value) {
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.add(value);
        queue.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        if (queue.peek().equals(maxQueue.peek())){
            maxQueue.poll();
        }
        return queue.poll();
    }
}
