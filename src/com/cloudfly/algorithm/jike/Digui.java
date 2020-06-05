package com.cloudfly.algorithm.jike;

import java.util.HashMap;
import java.util.Map;

/**
 * 注释
 *
 * @program: algorithm
 * @author: yunfeili6
 * @create: 2020-05-26 15:43
 */
public class Digui {

    private static Map<Integer, Integer> hasSolvedList = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        // hasSolvedList可以理解成一个Map，key是n，value是f(n)
        if (hasSolvedList.containsKey(n)) {
            return hasSolvedList.get(n);
        }

        int ret = f(n - 1) + f(n - 2);
        hasSolvedList.put(n, ret);
        return ret;
    }
}
