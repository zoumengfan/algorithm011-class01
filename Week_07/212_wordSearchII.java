class Solution {
    Set<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie(words);
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                 dfs(board, new boolean[m][n], trie, i, j, "");
            }
        }
        
        return new ArrayList<>(result);
    }
    
    private void dfs(char[][] board, boolean[][] visited, Trie trie, int i, int j, String cur) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }
        
        cur += board[i][j];
        if (!trie.startWith(cur)) {
            return;
        }
        
        if (trie.search(cur)) {
            result.add(cur);
        }
        
        visited[i][j] = true;
        dfs(board, visited, trie, i + 1, j, cur);
        dfs(board, visited, trie, i - 1, j, cur);
        dfs(board, visited, trie, i, j + 1, cur);
        dfs(board, visited, trie, i, j - 1, cur);
        visited[i][j] = false;
    }
    
    class Trie {
        TrieNode root;
        
        public Trie(String[] words) {
            this.root = new TrieNode('#');
            for (String s : words) {
                insert(s);
            }
        }
        
        public void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) {
                    cur.children[i] = new TrieNode(c);
                }
                cur = cur.children[i];
            }
            cur.isWord = true;
        }
        
        public boolean search(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) {
                    return false;
                }
                cur = cur.children[i];
            }
            return cur.isWord;
        }
        
        public boolean startWith(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) {
                    return false;
                }
                cur = cur.children[i];
            }
            return true;
        }
    }
    
    class TrieNode {
        char val;
        boolean isWord;
        TrieNode[] children;
        
        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
        }
    }
}