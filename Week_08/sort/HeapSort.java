package sort;

public class HeapSort {
    public int[] heapSort(int[] arr) {
        int len = arr.length;
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; --i) {
            swap(arr, 0, i);
            heapify(arr, 0, --len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; --i) {
            heapify(arr, i, arr.length);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
