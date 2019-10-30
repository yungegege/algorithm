package com.cloudfly.algorithm.offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-25 18:30
 */
public class Test7 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            b = a + b;
            a = b - a;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Test7().Fibonacci(6));
    }
}
