package com.isharpever.practice.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        for (int i = 1; i <= a.length; i++) {
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
    }
}
