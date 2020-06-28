class Solution {
    
// solution 1:
//     public void rotate(int[] nums, int k) {
//         int[] arr = new int[nums.length];
//         for (int i = 0; i < nums.length; ++i) {
//             arr[(i + k) % nums.length] = nums[i];
//         }
        
//         for (int i = 0; i < nums.length; ++i) {
//             nums[i] = arr[i];
//         }
//     }

// solution 2:
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int [] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
