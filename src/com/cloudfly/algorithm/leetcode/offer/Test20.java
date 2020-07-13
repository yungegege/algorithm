package com.cloudfly.algorithm.leetcode.offer;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"、"-1E-16"及"12e+5.4"都不是。
 */
public class Test20 {

    public static void main(String[] args) {
        System.out.println("1  ".trim());
        System.out.println(isNumber("-."));


        System.out.println(isNumber("+100"));
        System.out.println(isNumber("5e2"));
        System.out.println(isNumber("-123"));
        System.out.println(isNumber("3.1416"));
        System.out.println(isNumber("0123"));

        System.out.println(isNumber("12e"));
        System.out.println(isNumber("1a3.14"));
        System.out.println(isNumber("1.2.3"));
        System.out.println(isNumber("+-5"));
        System.out.println(isNumber("-1E-16"));
        System.out.println(isNumber("12e+5.4"));
    }

    /**
     * 包含e,分为两份,暴力就完事了
     */
    public static boolean isNumber(String s) {
        // 1.不能为空
        if ("".equals(s)) {
            return false;
        }
        s = s.trim();
        if (s.contains(" ") || "".equals(s)) {
            return false;
        }
        String str = s;
        if (str.contains("e")) {
            str = str.substring(0, str.indexOf("e"));
            if ("".equals(str)) {
                return false;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!((c <= '9' && c >= '0') || c == '.' || c == '+' || c == '-' || c == 'e')) {
                return false;
            }
        }

        // 2 第一位可以是+-或者数字
        if (str.length() - str.replace("+", "").length() > 1 || str.length() - str.replace("-", "").length() > 1
                ||str.indexOf("+") > 0 || str.indexOf("-") > 0) {
            return false;
        }
        if (str.contains("+") || str.contains("-")){
            if (str.length()==1){
                return false;
            }
            if (str.length()==2 && str.contains(".")){
                return false;
            }
        }
        // 3. 只能有一个小数点
        if (str.contains(".")) {
            if (str.length() - str.replace(".", "").length() > 1) {
                return false;
            }
            if (str.length() == 1) {
                return false;
            }
        }

        if (s.contains("e")) {
            s = s.substring(s.indexOf("e") + 1);
            if (s.contains(".") || s.contains("e")) {
                return false;
            }
            // 最多递归一次
            return isNumber(s);
        }
        return true;
    }
}
