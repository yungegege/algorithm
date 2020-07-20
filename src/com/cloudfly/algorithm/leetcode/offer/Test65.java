package com.cloudfly.algorithm.leetcode.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class Test65 {

    public static void main(String[] args) {
        System.out.println(add(3545, 253252));

    }

    public static int add(int a, int b) {
        int jinwei = 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int n = (a >> i) & 1;
            int m = (b >> i) & 1;
            // n和m异或和为1,说明n和m其中一个为0,另一个为1,要根据上一次循环的是否进位来判断本次是否需要进位
            if ((n ^ m) == 1) {
                if (jinwei == 0) {
                    // 进位为0,那么a+b的和 这一位就是1,并且不需要进位,进位还是为0
                    res |= (1 << i);
                } else {
                    // 进位为1,那么a+b的和 这一位就是0,并且需要进位,进位还是为1,那就啥都不用干
                }
            } else {
                // 此时n和m异或和为0,说明n和m全为1或者全为0,那么a+b的和的这一位就是上一次循环的进位
                if (jinwei == 1) {
                    res |= (1 << i);
                    jinwei = 0;
                }
                // 如果n&m==1,说明还是需要进位滴
                if ((n & m) == 1) {
                    jinwei = 1;
                }
            }

        }
        return res;
    }
}
