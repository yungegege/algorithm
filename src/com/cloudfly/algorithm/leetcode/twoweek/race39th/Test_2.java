package com.cloudfly.algorithm.leetcode.twoweek.race39th;

/**
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。
 * 我们称 s 平衡的 当不存在下标对 (i,j) 满足 i < j 且 s[i] = 'b' 同时 s[j]= 'a' 。
 * 请你返回使 s 平衡 的 最少 删除次数。
 */
public class Test_2 {

    public static void main(String[] args) {
        System.out.println(new Test_2().minimumDeletions("aabbbbaabababbbbaaaaaabbababaaabaabaabbbabbbbabbabbababaabaababbbbaaaaabbabbabaaaabbbabaaaabbaaabbbaabbaaaaabaa"));
    }

    /**
     * 输入：s = "aababbab"
     * 输出：2
     * 解释：你可以选择以下任意一种方案：
     * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
     * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
     *
     * @param s
     * @return
     */
    public int minimumDeletions(String s) {
        int res = Integer.MAX_VALUE;
        int bnum = 0;
        int[] aArr = new int[s.length()];
        int anum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                anum++;
            }
            aArr[i] = anum;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                int sum = bnum;
                sum += aArr[i];
                if (res > sum) {
                    res = sum;
                }
                bnum++;
            }
        }
        return Math.min(bnum, res);
    }
}
