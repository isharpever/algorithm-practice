package com.isharpever.practice.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个无序数组中两个数之和等于给定的值sum
 */
public class FindSum {

    public static void main(String[] args) {
        int[] a = new int[]{8, 6, 4, 7, 3, 9, 5, 2, 15};
        int sum = 10;

        List<int[]> result = find(a, sum);
        result.forEach(item -> System.out.println(Arrays.toString(item)));
    }

    private static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    private static void quickSort(int[] a, int l, int r) {
        int i = l - 1, tmp = a[r];

        for (int j = l; j < r; j++) {
            if (a[j] < tmp) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, r);
        if (l < i) {
            quickSort(a, l, i);
        }
        if (i + 2 < r) {
            quickSort(a, i + 2, r);
        }

    }

    private static List<int[]> find(int[] a, int sum) {
        List<int[]> result = new ArrayList<>();
        int n = a.length;
        quickSort(a, 0, n - 1);

        int l = 0, r = n - 1;
        while (l < r) {
            int s = a[l] + a[r];
            if (s == sum) {
                result.add(new int[]{a[l], a[r]});
                l++;
                r--;
            } else if (s < sum) {
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
