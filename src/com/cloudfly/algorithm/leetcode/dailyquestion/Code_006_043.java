package com.cloudfly.algorithm.leetcode.dailyquestion;

import java.util.ArrayList;
import java.util.List;

public class Code_006_043 {

    public static void main(String[] args) {
        Code_006_043 code_006_043 = new Code_006_043();
        String str = code_006_043.multiply("0", "12345");
        System.out.println(str);
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        List<String> list = new ArrayList<>();
        String wei = "";
        for (int i = 0; i < num2.length(); i++) {
            char a = num2.charAt(num2.length() - 1 - i);
            // a乘以num1,结果放入list
            String str = multiply(num1, a);
            str += wei;
            list.add(str);
            wei += "0";
        }
        String res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = add(res, list.get(i));
        }
        return res;
    }

    public String multiply(String str, char achar) {
        String res = "";
        int i = 0;
        int jinwei = 0;
        int a = achar - '0';
        while (i < str.length()) {
            int b = str.charAt(str.length() - 1 - i) - '0';
            res = (a * b + jinwei) % 10 + res;
            jinwei = (a * b + jinwei) / 10;
            i++;
        }
        if (jinwei > 0) {
            res = jinwei + res;
        }
        return res;
    }

    public String add(String s1, String s2) {
        String res = "";
        int i = 0;
        int jinwei = 0;
        int len = Math.abs(s1.length() - s2.length());
        String str = "";
        for (int j = 0; j < len; j++) {
            str = str + "0";
        }
        if (s1.length() < s2.length()) {
            s1 = str + s1;
        } else {
            s2 = str + s2;
        }
        while (i < s1.length()) {
            int a = s1.charAt(s1.length() - 1 - i) - '0';
            int b = s2.charAt(s2.length() - 1 - i) - '0';
            res = (a + b + jinwei) % 10 + res;
            jinwei = (a + b + jinwei) / 10;
            i++;
        }
        if (jinwei > 0) {
            res = jinwei + res;
        }
        return res;
    }
}
