package com.isharpever.practice.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort3(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int tmp = a[i + 1];
            int j;
            for (j = i; j >= 0 && a[j] > tmp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }

    private static void sort2(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    private static void sort3(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int tmp = a[i + 1];
            int j;
            for (j = i; j >= 0 && a[j] > tmp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }

    private static void sort4(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    private static void sort5(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }

    private static void sort6(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}
