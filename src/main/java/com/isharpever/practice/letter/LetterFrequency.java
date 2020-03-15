package com.isharpever.practice.letter;

/**
 * 统计26个字母在不同字符串中出现的频率,使用数组来存放每个字母出现的次数<br>
 * 如String[] inputs = {"abc", "def", "abc"}，输出为a: 2 b: 2 c: 2 d: 1 e: 1 f:1
 */
public class LetterFrequency {

    public static void main(String[] args) {
        String[] inputs = {"abc", "def", "abc"};

        int[] freq = new int[26];
        for (String word : inputs) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }
            System.out.print(String.format("%c:%d ", 'a' + i, freq[i]));
        }
        System.out.println("");
    }
}
