package com.isharpever.practice.sort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort3(a);
        System.out.println(Arrays.toString(a));
    }

    private static int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            max = a[i] > max ? a[i] : max;
        }
        return max;
    }

    private static void sort(int[] a) {
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(a, exp);
        }
    }

    private static void countSort(int[] a, int exp) {
        int n = a.length;
        int[] output = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            count[a[i] / exp % 10]++;
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[--count[a[i] / exp % 10]] = a[i];
        }

        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }

    private static void sort2(int[] a) {
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort2(a, exp);
        }
    }

    private static void countSort2(int[] a, int exp) {
        int n = a.length;
        int[] output = new int[n], count = new int[n];

        for (int i = 0; i < n; i++) {
            count[a[i] / exp % 10]++;
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[--count[a[i] / exp % 10]] = a[i];
        }
        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }

    private static void sort3(int[] a) {
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort3(a, exp);
        }
    }

    private static void countSort3(int[] a, int exp) {
        int n = a.length;
        int[] output = new int[n], count = new int[n];

        for (int i = 0; i < n; i++) {
            count[a[i] / exp % 10]++;
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[--count[a[i] / exp % 10]] = a[i];
        }
        for (int i = 0; i < n; i++) {
            a[i] = output[i];
        }
    }
}
