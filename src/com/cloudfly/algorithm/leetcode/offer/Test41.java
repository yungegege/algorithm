package com.cloudfly.algorithm.leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Test41 {

    public static void main(String[] args) {
        Test41 test41 = new Test41();
        System.out.println(test41.findMedian());

        test41.addNum(-1);
        System.out.println(test41.findMedian());

        test41.addNum(-2);
        System.out.println(test41.findMedian());

        test41.addNum(-3);
        System.out.println(test41.findMedian());

        test41.addNum(-4);
        System.out.println(test41.findMedian());

        test41.addNum(-5);
        System.out.println(test41.findMedian());

        test41.addNum(-6);
        System.out.println(test41.findMedian());
    }

    private Queue<Integer> smallQueue;
    private Queue<Integer> bigQueue;

    public Test41() {
        smallQueue = new PriorityQueue<>();
        bigQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        smallQueue.add(num);
        bigQueue.add(smallQueue.poll());
        if (bigQueue.size() - smallQueue.size() == 2) {
            smallQueue.add(bigQueue.poll());
        }
    }

    public double findMedian() {
        return bigQueue.size() > smallQueue.size() ? bigQueue.peek() : (smallQueue.peek() + bigQueue.peek()) / 2.0;
    }
}
