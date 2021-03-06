package com.cloudfly.algorithm.offer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @program: work
 * @author: yunfeili6
 * @create: 2019-10-23 11:13
 */
public class Test2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==32){
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        StringBuffer sb = new StringBuffer("We Are Happy");
        String s = test2.replaceSpace(sb);
        System.out.println(s);

    }
}
