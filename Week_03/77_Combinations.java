class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int n, int k, int start, List<Integer> cur, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = start; i <= n; ++i) {
            cur.add(i);
            backtrack(n, k - 1, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}