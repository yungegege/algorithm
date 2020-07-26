package com.cloudfly.algorithm.leetcode.oneweek.race199th;

import java.util.*;

/**
 * 行程长度编码 是一种常用的字符串压缩方法，它将连续的相同字符（重复 2 次或更多次）替换为字符和表示字符计数的数字（行程长度）。例如，用此方法压缩字符串 "aabccc" ，将 "aa" 替换为 "a2" ，"ccc" 替换为` "c3" 。因此压缩后的字符串变为 "a2bc3" 。
 * 注意，本问题中，压缩时没有在单个字符后附加计数 '1' 。
 * 给你一个字符串 s 和一个整数 k 。你需要从字符串 s 中删除最多 k 个字符，以使 s 的行程长度编码长度最小。
 * 请你返回删除最多 k 个字符后，s 行程长度编码的最小长度 。
 */
public class Test4 {

    public static void main(String[] args) {
        Test4 test4 = new Test4();
        System.out.println(test4.getLengthOfOptimalCompression("aaaaaaaaaaa", 1));
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int count = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                count += Math.min(i - list.get(list.size() - 1), 2);
                list.add(i);
            }
        }
        int aaa = 0;
        for (int i = chars.length - 1; i > 0; i--) {
            aaa += 1;
            if (chars[i] != chars[i - 1]) {
                break;
            }
        }
        count += Math.min(aaa, 2);
        list.add(s.length());
        if (k==0){
            return 3;
        }

        Map<Integer, List<Character>> map = new HashMap<>();
        for (int i = 0; i < list.size() - 1; i++) {
            // key：个数  value：char
            map.putIfAbsent(list.get(i + 1) - list.get(i), new ArrayList<>());
            map.get(list.get(i + 1) - list.get(i)).add(chars[list.get(i)]);
        }
        int res = 0;
        while (k > 0) {
            boolean flag = false;
            for (int i = 1; i <= Math.min(26, s.length()); i++) {
                List<Character> characterList = map.get(i);
                if (characterList == null) {
                    continue;
                }
                int a = k / i;
                int b = k % i;
                if (a >= characterList.size()) {
                    a = characterList.size();
                    b = 0;
                }
                // 出现i次的元素
                if (i == 1) {
                    k -= a;
                } else {
                    k -= 2 * a;
                }

                res += Math.min(i, 2) * a;
                if (i > 1 && b == i - 1) {
                    k--;
                    res += 1;
                }
                if (a==0 && (i==1 || b<i-1) ){
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        return count - res;
    }
}
