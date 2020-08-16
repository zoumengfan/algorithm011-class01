package sort;

public class CountingSort {
    public int[] countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];

        for (int i : arr) {
            ++count[i];
        }

        int index = 0;
        for (int i = 0; i < count.length; ++i) {
            while (count[i] > 0) {
                arr[index++] = i;
                --count[i];
            }
        }
        return arr;
    }
}
