package com.isharpever.practice.search;

/**
 * 两个有序数组查找第k大
 */
public class TwoArray {

    public static void main(String[] args) {
        int[] a = new int[]{8, 6, 4};
        int[] b = new int[]{9, 7, 5};
        int k = 5;
        int result = find(a, b, k);
        System.out.println(result);
    }

    private static int find(int[] a, int[] b, int k) {
        int i = 0, j = 0, result = -1;
        while (k > 0 && i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                result = a[i];
                i++;
            } else {
                result = b[j];
                j++;
            }
            k--;
        }
        if (k <= 0) {
            return result;
        }
        while (k > 0 && i < a.length) {
            result = a[i];
            i++;
            k--;
        }
        if (k <= 0) {
            return result;
        }
        while (k > 0 && j < b.length) {
            result = b[i];
            i++;
            k--;
        }
        return result;
    }
}
