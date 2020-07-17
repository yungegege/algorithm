package com.cloudfly.algorithm.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 */
public class Test50 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff"));
    }

    public static char firstUniqChar(String s) {
        if (s==null){
            return ' ';
        }
        int[] arr = new int[26];
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            arr[charArr[i]-'a'] +=1;
        }
        for (int i = 0; i < charArr.length; i++){
            if (arr[charArr[i]-'a']==1) {
                return charArr[i];
            }
        }
        return ' ';

    }
}
