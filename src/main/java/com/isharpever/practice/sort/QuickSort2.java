package com.isharpever.practice.sort;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort3(a, 0, a.length - 1);
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
        int i = l - 1, tmp = a[r];

        for (int j = l; j < r; j++) {
            if (a[j] < tmp) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        if (l < i) {
            sort2(a, l, i);
        }
        if (i + 2 < r) {
            sort2(a, i + 2, r);
        }
    }

    private static void sort3(int[] a, int l, int r) {
        int i = l - 1, tmp = a[r];

        for (int j = l; j < r; j++) {
            if (a[j] < tmp) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        if (l < i) {
            sort3(a, l, i);
        }
        if (i + 2 < r) {
            sort3(a, i + 2, r);
        }
    }
}
