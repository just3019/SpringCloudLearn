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
            if (arr[i] > arr[i + 1]) {
                int t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 4};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
