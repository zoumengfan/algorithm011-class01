class Solution {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < parent.length; ++i) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
                --count;
            }
        }

        public int count() {
            return count;
        }
    }
}