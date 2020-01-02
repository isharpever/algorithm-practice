package com.isharpever.practice.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int length = 10, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        a = sort3(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static int[] sort(int[] a, int l, int r) {
        int[] output = new int[r -l + 1];
        if (l == r) {
            output[0] = a[l];
            return output;
        }

        int mid = (l + r) / 2;
        int[] a1 = sort(a, l, mid);
        int[] a2 = sort(a, mid + 1, r);

        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                output[k] = a1[i++];
            } else {
                output[k] = a2[j++];
            }
            k++;
        }
        while (i < a1.length) {
            output[k++] = a1[i++];
        }
        while (j < a2.length) {
            output[k++] = a2[j++];
        }
        return output;
    }

    private static int[] sort2(int[] a, int l, int r) {
        int[] output = new int[r - l + 1];
        if (l == r) {
            output[0] = a[l];
            return output;
        }

        int m = (l + r) / 2;
        int[] a1 = sort2(a, l, m);
        int[] a2 = sort2(a, m + 1, r);

        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                output[k] = a1[i++];
            } else {
                output[k] = a2[j++];
            }
            k++;
        }
        while (i < a1.length) {
            output[k++] = a1[i++];
        }
        while (j < a2.length) {
            output[k++] = a2[j++];
        }
        return output;
    }

    private static int[] sort3(int[] a, int l, int r) {
        int[] output = new int[r - l + 1];
        if (l == r) {
            output[0] = a[l];
            return output;
        }

        int m = (l + r) / 2;
        int[] a1 = sort3(a, l, m);
        int[] a2 = sort3(a, m + 1, r);

        int i = 0, j = 0, k = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                output[k] = a1[i++];
            } else {
                output[k] = a2[j++];
            }
            k++;
        }
        while (i < a1.length) {
            output[k++] = a1[i++];
        }
        while (j < a2.length) {
            output[k++] = a2[j++];
        }
        return output;
    }
}
