package com.cloudfly.algorithm.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-25 18:52
 */
public class Test11 {
    public int NumberOf1(int n) {
        int count = 0;
        while (n!=0){
            n = n&(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Test11().NumberOf1(-2));
        System.out.println(new Test11().NumberOf1(-1));
        System.out.println(new Test11().NumberOf1(-0));
        System.out.println(new Test11().NumberOf1(0));
        System.out.println(new Test11().NumberOf1(3));
        System.out.println(new Test11().NumberOf1(4));
        System.out.println(new Test11().NumberOf1(5));
        System.out.println(new Test11().NumberOf1(6));
        System.out.println(new Test11().NumberOf1(7));
        System.out.println(new Test11().NumberOf1(787));
        System.out.println(1<<30);
        System.out.println(1<<31);
        System.out.println(1<<32);
        System.out.println(1<<33);
        System.out.println((1<<31)-1);
        System.out.println(Integer.MAX_VALUE == 2147483647);
    }
}
