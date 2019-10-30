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
        int sum = 0;
        int a = n;
        n = n>0?n:-n;
        while (n>0){
            if (n%2==1){
                sum++;
            }
            n/=2;
        }
        return a>=0?sum:sum+1;
    }

    public static void main(String[] args) {
        System.out.println(new Test11().NumberOf1(-2));
        System.out.println(new Test11().NumberOf1(3));
        System.out.println(new Test11().NumberOf1(4));
        System.out.println(new Test11().NumberOf1(5));
    }
}
