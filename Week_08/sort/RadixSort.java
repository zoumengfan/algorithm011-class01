package sort;

public class RadixSort {
    public int[] radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Integer.max(max, i);
        }

        int[][] bucket;

        for (int i = 1; i < max; i *= 10) {
            bucket = new int[10][arr.length];

            for (int j = 0; j < arr.length; ++j) {
                bucket[(arr[j] / i) % 10][j] = arr[j];
            }

            int index = 0;
            for (int j = 0; j < 10; ++j) {
                for (int k = 0; k < arr.length; ++k) {
                    if (bucket[j][k] != 0) {
                        arr[index++] = bucket[j][k];
                    }
                }
            }
        }

        return arr;
    }
}
