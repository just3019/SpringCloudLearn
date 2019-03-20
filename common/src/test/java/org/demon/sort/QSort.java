package org.demon.sort;

public class QSort {

    public void qSort(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= key) {
                high--;

            }
        }

    }
}
