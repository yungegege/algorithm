package com.cloudfly.algorithm.leetcode.twoweek.race39th;

/**
 * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
 * <p>
 * 跳蚤跳跃的规则如下：
 * <p>
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何 forbidden 数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 * <p>
 * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，
 * 同时给你整数 a， b 和 x ，请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
 */
public class Test_3 {

    public static void main(String[] args) {
        System.out.println(new Test_3().minimumJumps(new int[]{
                162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98
        }, 29,98,80));
    }

    /**
     * @param forbidden 不能站的位置
     * @param a         往右a个位置
     * @param b         往左b个位置
     * @param x         终点
     * @return
     */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // 记录不能跳的位置
        int[] arr = new int[2001];
        for (int i = 0; i < forbidden.length; i++) {
            arr[forbidden[i]] = 1;
        }
        // 往右n步 往左m步  an-bm=x  中间不能在arr上
        int index = 0;
        int res = 0;
        while (true) {
            res++;
            index += a;
            if (index < arr.length && arr[index] == 1) {
                return -1;
            }
            if ((index - x) % b == 0) {
                if ((index - x) / b > 1) {
                    return -1;
                }
                return res + (index - x) / b;
            }
        }
    }
}
