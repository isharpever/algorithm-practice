package com.isharpever.practice.search;

/**
 * 给定一个字符串S，S中只有'A'和'B'
 * 例如：
 *   "ABBA" -> true
 *   "ABA" -> false
 *   "ABABA" -> true
 * 如果能在S中找到不想交的"AB"和"BA"子串，那么返回true，不然会返回false
 */
public class FindABBA {

    public static void main(String[] args) {
        String test = "ABABA";
        boolean result = find2(test);
        System.out.println(result);
    }

    private static boolean find(String str) {
        if (str.length() < 4) {
            return false;
        }

        // 第1次,首先找AB
        int abIndex = str.indexOf("AB");
        if (abIndex >= 0) {
            String subStr = str.substring(abIndex + 2);
            int baIndex = subStr.indexOf("BA");
            if (baIndex >= 0) {
                return true;
            }
        }

        // 第2次,首先找BA
        int baIndex = str.indexOf("BA");
        if (baIndex >= 0) {
            String subStr = str.substring(baIndex + 2);
            abIndex = subStr.indexOf("AB");
            if (abIndex >= 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean find2(String str) {
        int n = str.length();

        int l = 0, r = str.length() - 2;
        while (l < n - 1 && (str.charAt(l) != 'A' || str.charAt(l + 1) != 'B')) {
            l++;
        }
        while (r > 0 && (str.charAt(r) != 'B' || str.charAt(r + 1) != 'A')) {
            r--;
        }
        if (r - l >= 2) {
            return true;
        }

        l = 0;
        r = str.length() - 2;
        while (l < n - 1 && (str.charAt(l) != 'B' || str.charAt(l + 1) != 'A')) {
            l++;
        }
        while (r > 0 && (str.charAt(r) != 'A' || str.charAt(r + 1) != 'B')) {
            r--;
        }
        if (r - l >= 2) {
            return true;
        }

        return false;
    }
}
