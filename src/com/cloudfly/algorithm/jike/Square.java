package com.cloudfly.algorithm.jike;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-05-28 14:44
 */
public class Square {
    public static void main(String[] args) {
        double a = square(5D, 0.001);
        double b = square(0.5D, 0.001);
        System.out.println(a);
        System.out.println(b);
    }

    private static double square(double value, double p) {
        double low = 1;
        double high = value;
        if (value < 1) {
            low = value;
            high = 1;
        }
        double mid = (low + high) / 2;
        while (Math.abs(mid * mid - value) > p) {
            if (mid * mid > value) {
                high = mid;
            } else {
                low = mid;
            }
            mid =  (low + high) / 2;
        }
        return mid;
    }
}
