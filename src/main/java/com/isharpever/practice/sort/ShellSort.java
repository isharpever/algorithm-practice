package com.isharpever.practice.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort3(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int n = a.length;
        for (int tag = n / 2; tag > 0; tag /= 2) {
            for (int i = tag; i < n; i++) {
                int tmp = a[i];
                int j;
                for (j = i; j >= tag && a[j - tag] > tmp; j -= tag) {
                    a[j] = a[j - tag];
                }
                a[j] = tmp;
                System.out.println(Arrays.toString(a));
            }
            System.out.println(Arrays.toString(a));
        }
    }

    private static void sort2(int[] a) {
        int n = a.length;
        for (int tag = n / 2; tag > 0; tag /= 2) {
            for (int i = tag; i < n; i++) {
                int tmp = a[i];
                int j;
                for (j = i; j >= tag && a[j - tag] > tmp; j -= tag) {
                    a[j] = a[j - tag];
                }
                a[j] = tmp;
            }
        }
    }

    private static void sort3(int[] a) {
        int n = a.length;
        for (int tag = n / 2; tag > 0; tag /= 2) {
            for (int i = tag; i < n; i++) {
                int tmp = a[i];
                int j;
                for (j = i; j >= tag && a[j - tag] > tmp; j -= tag) {
                    a[j] = a[j - tag];
                }
                a[j] = tmp;
            }
        }
    }
}
