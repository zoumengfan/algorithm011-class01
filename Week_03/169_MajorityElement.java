class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            if (++count > nums.length / 2) {
                return i;
            }
            
            map.put(i, count);
        }
        
        return -1;
    }
}