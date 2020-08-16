class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        
        for (int i = 0; i < arr1.length; ++i) {
            ++count[arr1[i]];
        }
        
        int x = 0;
        for (int i = 0; i < arr2.length; ++i) {
            for (int j = 0; j < count[arr2[i]]; ++j) {
                arr1[x++] = arr2[i];
            }
            count[arr2[i]] = 0;
        }
        
        for (int i = 0; i < count.length; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                arr1[x++] = i;
            }
        }
        return arr1;
    }
}