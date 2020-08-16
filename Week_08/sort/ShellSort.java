package sort;

import java.util.Collections;

public class ShellSort {
    public int[] shellSort(int[] arr) {
        int len = arr.length;

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; ++i) {
                int j = i;
                int cur = arr[i];

                while (j - gap >= 0 && arr[j - gap] > cur) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = cur;
            }
        }
        return arr;
    }
}
