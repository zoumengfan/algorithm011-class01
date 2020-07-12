class Solution {
    private Set<Integer> col = new HashSet<>();
    private Set<Integer> pie = new HashSet<>();
    private Set<Integer> na = new HashSet<>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, n, result, new ArrayList<>());
        return result;
    }
    
    private void dfs(int row, int n, List<List<String>> result, List<String> cur) {
        if (row == n) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < n; ++i) {
            if (col.contains(i) || pie.contains(row + i) || na.contains(row - i)) {
                continue;
            }
            
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[i] = 'Q';
        
            col.add(i);
            pie.add(row + i);
            na.add(row - i);
            cur.add(new String(c));
            
            dfs(row + 1, n, result, cur);
            
            col.remove(i);
            pie.remove(row + i);
            na.remove(row - i);
            cur.remove(cur.size() - 1);
        }
    }
}