package com.isharpever.practice.search;

/**
 * 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
//        int index = search(a, 0, a.length - 1, 1);
        int index = search2(a, 5);

        System.out.println(index);
    }

    private static int search(int[] a, int l, int r, int t) {
        if (l > r) {
            return -1;
        }

        int m = (l + r) / 2;
        if (a[m] == t) {
            return m;
        } else if (a[m] > t) {
            return search(a, l, m - 1, t);
        } else {
            return search(a, m + 1, r, t);
        }
    }

    private static int search2(int[] a, int t) {
        int l = 0, r = a.length - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
