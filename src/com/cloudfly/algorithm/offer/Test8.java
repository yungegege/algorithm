package com.cloudfly.algorithm.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-25 18:43
 */
public class Test8 {
    public int JumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;
        for (int i = 0; i < target; i++) {
            b += a;
            a = b - a;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Test8().JumpFloor(5));
    }
}
