package sort;

public class InsertionSort {
    public int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            int j = i - 1;
            int cur = arr[i];

            while (j >= 0 && cur < arr[j]) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = cur;
        }
        return arr;
    }
}
