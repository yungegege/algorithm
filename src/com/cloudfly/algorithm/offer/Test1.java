package com.cloudfly.algorithm.offer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-23 10:46
 */
public class Test1 {

    public static boolean Find(int target, int[][] array) {
        if (null == array || array.length == 0 || array[0] == null || array[0].length == 0) {
            return false;
        }
        for (int i = 0, j = array[0].length - 1; i < array.length && j >= 0; ) {
            if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10}
        };
        System.out.println(Find(2, arr));
    }
}
