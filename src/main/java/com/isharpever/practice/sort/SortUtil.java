package com.isharpever.practice.sort;

import java.util.Random;

public class SortUtil {

    public static int[] generateRandomArray(int length, int bound) {
        int[] result = new int[length];
        Random random = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(bound);
        }
        return result;
    }

}
