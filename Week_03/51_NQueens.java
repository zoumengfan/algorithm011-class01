class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] col = new boolean[n];
        boolean[] pie = new boolean[n * 2];
        boolean[] na = new boolean[n * 2];
        dfs(0, n, result, col, pie, na, new ArrayList<>());
        return result;
    }
    
    private void dfs(int row, int n, List<List<String>> result, 
                     boolean[] col, boolean[] pie, boolean[] na, List<String> cur) {
        if (row == n) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        for (int i = 0; i < n; ++i) {
            if (col[i] || pie[row + i] || na[n + row - i]) {
                continue;
            }
            
            char[] c = new char[n];
            Arrays.fill(c, '.');
            c[i] = 'Q';
        
            col[i] = true;
            pie[row + i] = true;
            na[n + row - i] = true;
            cur.add(new String(c));
            
            dfs(row + 1, n, result, col, pie, na, cur);
            
            col[i] = false;
            pie[row + i] = false;
            na[n + row - i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}