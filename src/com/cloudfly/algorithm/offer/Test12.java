package com.cloudfly.algorithm.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-09 10:43
 */
public class Test12 {
    public static void main(String[] args) {
        System.out.println(new Test12().Power(2.5,0));
        System.out.println(Math.pow(2.5,0));
    }

    public double Power(double base, int exponent) {
        int n = 0;
        if (exponent>0){
            n = exponent;
        }else if (exponent==0){
            return 1;
        }else if (exponent<0){
            if (base<0){
                return 0;
            }
            n = -exponent;
        }
        int count = 0;
        double y = 0;
        double result = 1;
        while (n>0){
            if (count==0){
                y = base;
            }else {
                y = y*y;
            }
            if ((n&1)==1){
                result*=y;
            }
            n = n>>1;
            count++;
        }
        return exponent>0?result:1/result;
    }
}
