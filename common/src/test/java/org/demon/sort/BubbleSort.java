package org.demon.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    private static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = 0; j < (arr.length - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
