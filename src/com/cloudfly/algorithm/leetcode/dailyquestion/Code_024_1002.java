package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 示例 2：
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class Code_024_1002 {

    public static void main(String[] args) {
        char a = 'a' + 1;
        System.out.println(String.valueOf(a));
        System.out.println(new Code_024_1002().commonChars(new String[]{
                "cool", "lock", "cook"
        }));
    }

    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] arr = new int[26];
        int[] brr;
        for (int i = 0; i < A.length; i++) {
            brr = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                if (i == 0) {
                    arr[A[i].charAt(j) - 'a']++;
                } else {
                    brr[A[i].charAt(j) - 'a']++;
                }
            }
            if (i > 0) {
                for (int k = 0; k < 26; k++) {
                    arr[k] = Math.min(arr[k], brr[k]);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }
}
