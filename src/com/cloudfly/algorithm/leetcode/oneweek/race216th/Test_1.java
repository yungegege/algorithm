package com.cloudfly.algorithm.leetcode.oneweek.race216th;

/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * 示例 1：
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * 示例 2：
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * 示例 3：
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * 提示：
 * 1 <= word1.length, word2.length <= 103
 * 1 <= word1[i].length, word2[i].length <= 103
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 * word1[i] 和 word2[i] 由小写字母组成
 */
public class Test_1 {

    public static void main(String[] args) {
        System.out.println(new Test_1().arrayStringsAreEqual(new String[]{
                "ab", "c"
        }, new String[]{
                "a", "bc"
        }));
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0;
        int j1 = 0;
        int i2 = 0;
        int j2 = 0;
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1++) != word2[i2].charAt(j2++)) {
                return false;
            }
            if (j1 >= word1[i1].length()) {
                i1++;
                j1 = 0;
            }
            if (j2 >= word2[i2].length()) {
                i2++;
                j2 = 0;
            }
        }
        return i1 == word1.length && j1 == 0 && i2 == word2.length && j2 == 0;
    }
}
