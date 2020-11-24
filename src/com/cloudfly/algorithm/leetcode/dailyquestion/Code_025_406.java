package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。
 * 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
 * <p>
 * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
 * <p>
 * 示例：
 * <p>
 * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Code_025_406 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2},
        };
        int[][] ints = new Code_025_406().reconstructQueue(arr);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }

    /**
     * 从高到低，不初始化数组，对于每个人，插到自己k值的位置
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * 从低到高排序，建好people.length个数组，对于每个人，数空位，到第k个插入
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int num = o1[0] - o2[0];
                return num != 0 ? num : o2[1] - o1[1];
            }
        });
        int[][] arr = new int[people.length][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = -1;
        }
        for (int i = 0; i < people.length; i++) {
            int j = 0;
            int index = 0;
            while (j <= people[i][1]) {
                if (arr[index++][0] == -1) {
                    j++;
                }
            }
            arr[index - 1][0] = people[i][0];
            arr[index - 1][1] = people[i][1];
        }
        return arr;
    }
}
