package com.isharpever.practice.sort;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static void sort(int[] a, int l, int r) {
        int i = l - 1, tmp = a[r];

        for (int j = l; j < r; j++) {
            if (a[j] < tmp) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        if (l < i) {
            sort(a, l, i);
        }
        if (i + 2 < r) {
            sort(a, i + 2, r);
        }
    }

    private static void sort2(int[] a, int l, int r) {
        int i = l, tmp = a[r];

        for (int j = l; j < r; j++) {
            if (a[j] < tmp) {
                swap(a, i++, j);
            }
        }
        swap(a, i, r);
        if (l < i - 1) {
            sort2(a, l, i - 1);
        }
        if (r > i + 1) {
            sort2(a, i + 1, r);
        }
    }
}
