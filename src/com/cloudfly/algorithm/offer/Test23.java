package com.cloudfly.algorithm.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-18 11:32
 */
public class Test23 {
    public static void main(String[] args) {
        System.out.println(new Test23().VerifySquenceOfBST(
                new int[]{
                        1, 2, 4, 8, 9, 7, 5
                }
        ) ? "YES" : "NO");
    }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int start = 0;
        int end = sequence.length;
        return aaa(sequence, start, end);
    }

    private boolean aaa(int[] sequence, int start, int end) {
        if (start == -1) {
            return true;
        }
        if (start >= end) {
            return true;
        }
        int root = sequence[end - 1];
        int index = -1;
        int count = 0;
        for (int i = start; i < end; i++) {
            if (sequence[i] > root && count == 0) {
                index = i;
                count++;
            }
            if (count > 0 && sequence[i] < root) {
                return false;
            }
        }
        return aaa(sequence, start, index) && aaa(sequence, index, end - 1);
    }

    /**
     * 这种写法很牛批
     *
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST2(int[] sequence) {
//        作者：skoy12
//        链接：https://www.nowcoder.com/questionTerminal/a861533d45854474ac791d90e447bafd
//        来源：牛客网
        if (sequence.length == 0) {
            return false;
        }
        for (int i = 0; i < sequence.length; i++) {
            boolean sign = false;
            for (int j = 0; j < i; j++) {
                if (sequence[j] > sequence[i]) {
                    sign = true;
                } else if (sign) {
                    return false;
                }
            }
        }
        return true;
    }
}
