package com.cloudfly.algorithm.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-25 18:45
 */
public class Test9 {
    public int JumpFloorII(int target) {
        if (target==0 || target==1){
            return target;
        }
        int sum = 1;
        while (--target>0){
            sum*=2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Test9().JumpFloorII(3));
    }
}
