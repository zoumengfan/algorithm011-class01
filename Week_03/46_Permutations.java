class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i : nums) {
            if (cur.contains(i)) {
                continue;
            }
            
            cur.add(i);
            backtrack(nums, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}