package com.cloudfly.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目:
 * 数组中出现次数超过一半的数字
 * 题目描述:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2019-12-18 12:07
 */
public class Test28 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new Test28().MoreThanHalfNum_Solution(array));
    }

    public int MoreThanHalfNum_Solution(int[] array) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashMap.get(array[i]) == null) {
                hashMap.put(array[i], 1);
            } else {
                hashMap.put(array[i], hashMap.get(array[i]) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > array.length/2) {
                result = entry.getKey();
            }
        }
        return result;
    }
}
