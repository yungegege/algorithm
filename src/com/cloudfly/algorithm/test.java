package com.cloudfly.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test {

    public static void main(String[] args) {

    }

    /**
     * arr有序，要求把重复元素放到最后
     * 1 1 3 3 4 4
     * 1 2 3 4 3 4
     *
     * @param arr
     * @return
     */
    public int[] method(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int[] res = new int[arr.length];
        int index = 1;
        res[0] = arr[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        // 前面的
        for (int i = 1; i < arr.length; i++) {
            map.put(arr[i], map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1);
            if (arr[i] > arr[i - 1]) {
                res[index++] = arr[i];
            }
        }
        // 有重复的元素
        for (int i = 0; i < arr.length; i++) {
            int count = map.get(arr[i]);
            for (int j = 0; j < count - 1; j++) {
                res[index++] = arr[i];
            }
            i = i + count - 1;
        }
        return res;
    }
}
