package sort;

public class QuickSort {
    public int[] quickSort(int[] arr) {
        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return arr;
        }

        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index + 1, right);
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;

        for (int i = index; i <= right; ++i) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index++);
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
