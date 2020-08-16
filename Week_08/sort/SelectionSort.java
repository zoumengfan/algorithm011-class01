package sort;

import java.util.Arrays;

public class SelectionSort {
    public int[] selectionSort(int[] arr) {
        int min, temp;
        for (int i = 0; i < arr.length - 1; ++i) {
            min = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }
}
