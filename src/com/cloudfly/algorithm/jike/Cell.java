package com.cloudfly.algorithm.jike;

/**
 * 1个细胞的生命周期是3小时，1小时分裂一次。
 * 求n小时后，容器内有多少细胞？请你用已经学过的递归时间复杂度的分析方法，分析一下这个递归问题的时间复杂度。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-05-29 17:10
 */
public class Cell {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + i + "小时," + cell(i) + "个");
        }
    }

    /**
     * n小时后分裂个数
     *
     * @param n
     */
    public static int cell(int n) {
        if (n < 1) {
            return 1;
        }
        if (n < 3) {
            return n * 2;
        }
        return cell(n - 1) * 2 - cell(n - 4);
    }
}
