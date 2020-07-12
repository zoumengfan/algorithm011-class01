class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        backtrack(nums, visit, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visit, List<Integer> cur, List<List<Integer>> result) {
        if (nums.length == cur.size()) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (visit[i]) {
                continue;
            }
            
            if (i > 0 && !visit[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            
            visit[i] = true;
            cur.add(nums[i]);
            backtrack(nums, visit, cur, result);
            visit[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}