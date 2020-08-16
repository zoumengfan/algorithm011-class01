package sort;

public class MergeSort {
    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        for (int i = 0; i < mid; ++i) {
            left[i] = arr[i];
        }

        for (int i = 0; i < arr.length - mid; ++i) {
            right[i] = arr[i + mid];
        }

        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int l = 0, r = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (l >= left.length || (r < right.length && left[l] > right[r])) {
                arr[i] = right[r++];
            } else {
                arr[i] = left[l++];
            }
        }
        return arr;
    }
}
