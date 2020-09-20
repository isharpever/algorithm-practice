package com.isharpever.practice.sort;

import java.util.Arrays;

public class QuickSort3 {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static void sort(int[] a, int l, int r) {
        int s = l, e = r, tmp = a[l];

        r++;
        while (l < r) {
            l++;
            if (l < r) {
                r--;
            }

            while (l < r && a[l] < tmp) {
                l++;
            }

            while (l < r && a[r] > tmp) {
                r--;
            }

            if (l < r) {
                swap(a, l, r);
            }
        }
        assert l == r;
        if (tmp > a[l]) {
            swap(a, s, l);
        }
        if (s < l - 1) {
            sort(a, s, l - 1);
        }
        if (e > l) {
            sort(a, l, e);
        }
    }
}
