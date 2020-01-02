package com.isharpever.practice.sort;

import java.util.Arrays;

/**
 * 计数排序
 */
public class CountSort {

    public static void main(String[] args) {
        int length = 10, bound = 50;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort2(a, bound);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a, int bound) {
        int[] bucket = new int[bound];

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
        int k = 0;
        for (int i = 0; i < bound; i++) {
            while (bucket[i]-- > 0) {
                a[k++] = i;
            }
        }
    }

    private static void sort2(int[] a, int bound) {
        int[] bucket = new int[bound];

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }
        int k = 0;
        for (int i = 0; i < bound; i++) {
            while (bucket[i]-- > 0) {
                a[k++] = i;
            }
        }
    }
}
