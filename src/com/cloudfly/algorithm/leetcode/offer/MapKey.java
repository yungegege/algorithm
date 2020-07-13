package com.cloudfly.algorithm.leetcode.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class MapKey{

    public static void main(String[] args) {
        A  a = new A();
        a.str = "a";
        Map<A,String> map = new HashMap<>();
        map.put(a,"11111");
        System.out.println(map.get(a));
        a.str = "b";
        System.out.println(map.get(a));
    }

    public static int cuttingRope(int n) {
        return 0;
    }
}

class A{
    String str;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(str, a.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
