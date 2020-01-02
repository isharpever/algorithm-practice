package com.isharpever.practice.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int length = 20, bound = 100;
        int[] a = SortUtil.generateRandomArray(length, bound);

        System.out.println(Arrays.toString(a));
        sort6(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a, int l, int r) {
        int s = l, e = r;
        int x = a[l];

        outer:
        while (l < r) {
            while (a[r] >= x) {
                if (--r <= l) {
                    break outer;
                }
            }
            a[l] = a[r];

            if (++l >= r) {
                break;
            }

            while (a[l] <= x) {
                if (++l >= r) {
                    break outer;
                }
            }
            a[r] = a[l];
            r--;
        }
        if (l > s) {
            a[l] = x;
        }
        if (s < l - 1) {
            sort(a, s, l - 1);
        }
        if (l + 1 < e) {
            sort(a, l + 1, e);
        }
    }

    private static void sort2(int[] a, int l, int r) {
        int s = l, e = r;
        int x = a[l];

        outer:
        while (l < r) {
            while (a[r] >= x) {
                if (--r <= l) {
                    break outer;
                }
            }
            a[l] = a[r];

            if (++l >= r) {
                break;
            }

            while (a[l] <= x) {
                if (++l >= r) {
                    break outer;
                }
            }
            a[r] = a[l];
            r--;
        }
        assert l == r;
        if (l > s) {
            a[l] = x;
        }
        if (s < l - 1) {
            sort2(a, s, l - 1);
        }
        if (l + 1 < e) {
            sort2(a, l + 1, e);
        }
    }

    private static void sort3(int[] a, int l, int r) {
        int s = l, e = r;
        int x = a[l];

        outer:
        while (l < r) {
            while (a[r] > x) {
                if (--r <= l) {
                    break outer;
                }
            }
            a[l] = a[r];

            if (++l >= r) {
                break;
            }

            while (a[l] < x) {
                if (++l >= r) {
                    break outer;
                }
            }
            a[r] = a[l];
            r--;
        }
        assert l == r;
        if (l > s) {
            a[l] = x;
        }
        if (s < l - 1) {
            sort3(a, s, l - 1);
        }
        if (l + 1 < e) {
            sort3(a, l + 1, e);
        }
    }

    private static void sort4(int[] a, int l, int r) {
        int s = l, e = r, x = a[l];

        outer:
        while (l < r) {
            while (a[r] > x) {
                if (--r <= l) {
                    break outer;
                }
            }
            a[l] = a[r];

            if (++l >= r) {
                break;
            }

            while (a[l] < x) {
                if (++l >= r) {
                    break outer;
                }
            }
            a[r] = a[l];
            r--;
        }
        assert l == r;
        if (l > s) {
            a[l] = x;
        }
        if (s < l - 1) {
            sort4(a, s, l - 1);
        }
        if (l + 1 < e) {
            sort4(a, l + 1, e);
        }
    }

    private static void sort5(int[] a, int l, int r) {
        int s = l, e = r, x = a[l];

        outer:
        while (l < r) {
            while (a[r] >= x) {
                if (--r <= l) {
                    break outer;
                }
            }
            a[l] = a[r];

            if (++l >= r) {
                break;
            }

            while (a[l] <= x) {
                if (++l >= r) {
                    break outer;
                }
            }
            a[r--] = a[l];
        }
        assert l == r;
        if (l > s) {
            a[l] = x;
        }
        if (s < l - 1) {
            sort5(a, s, l - 1);
        }
        if (e > l + 1) {
            sort5(a, l + 1, e);
        }
    }

    private static void sort6(int[] a, int l, int r) {
        int s = l, e = r, x = a[l];

        outer:
        while (l < r) {
            while (a[r] >= x) {
                if (--r <= l) {
                    break outer;
                }
            }
            a[l] = a[r];

            if (++l >= r) {
                break;
            }

            while (a[l] <= x) {
                if (++l >= r) {
                    break outer;
                }
            }
            a[r--] = a[l];
        }
        assert l == r;
        if (l > s) {
            a[l] = x;
        }
        if (s < l - 1) {
            sort6(a, s, l - 1);
        }
        if (e > l + 1) {
            sort6(a, l + 1, e);
        }
    }
}
