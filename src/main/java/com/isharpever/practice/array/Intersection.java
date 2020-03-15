package com.isharpever.practice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个有序数组求交集
 */
public class Intersection {

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {3, 4, 5};

        List<Integer> result = intersection(a, b);
        System.out.println(result);
    }

    private static List<Integer> intersection(int[] a, int[] b) {
        int i = 0, j = 0;

        List<Integer> result = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                result.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
