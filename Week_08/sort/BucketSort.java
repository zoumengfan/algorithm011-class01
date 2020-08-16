package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BucketSort {
    public int[] bucketSort(int[] arr, int size) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }

        List<Integer>[] bucket = new List[(max - min) / size + 1];
        for (int i : arr) {
            int index = (i - min) / size;
            if (bucket[index] == null) {
                bucket[index] = new ArrayList<>();
            }
            bucket[index].add(i);
        }

        int index = 0;
        for (List<Integer> list : bucket) {
            list.sort(Comparator.naturalOrder());
            for (int i : list) {
                arr[index++] = i;
            }
        }
        return arr;
    }
}
