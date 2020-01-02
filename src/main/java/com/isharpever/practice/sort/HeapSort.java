package com.isharpever.practice.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort3(a);
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static void heapify(int[] a, int n, int t) {
        int l = 2 * t + 1, r = 2 * t + 2;
        int largest = t;

        if (l < n && a[l] > a[t]) {
            largest = l;
        }
        if (r < n && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != t) {
            swap(a, t, largest);
            heapify(a, n, largest);
        }
    }

    private static void sort(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(a, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }

    private static void heapify2(int[] a, int n, int t) {
        int l = 2 * t + 1, r = 2 * t + 2;
        int nt = t;

        if (l < n && a[l] > a[t]) {
            nt = l;
        }
        if (r < n && a[r] > a[nt]) {
            nt = r;
        }
        if (nt != t) {
            swap(a, t, nt);
            heapify2(a, n, nt);
        }
    }

    private static void sort2(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify2(a, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapify2(a, i, 0);
        }
    }

    private static void heapify3(int[] a, int n, int t) {
        int l = 2 * t + 1, r = 2 * t + 2;
        int nt = t;

        if (l < n && a[l] > a[nt]) {
            nt = l;
        }
        if (r < n && a[r] > a[nt]) {
            nt = r;
        }
        if (nt != t) {
            swap(a, t, nt);
            heapify3(a, n, nt);
        }
    }

    private static void sort3(int[] a) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify3(a, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapify3(a, i, 0);
        }
    }
}
