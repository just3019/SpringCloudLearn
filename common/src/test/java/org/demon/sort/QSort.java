package org.demon.sort;

import java.util.Arrays;

public class QSort {

    private static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            qSort(arr, low, pivot - 1);
            qSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        System.out.println(Arrays.toString(arr));
        return low;
    }


    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        qSort(arr, 0, arr.length - 1);
    }
}
