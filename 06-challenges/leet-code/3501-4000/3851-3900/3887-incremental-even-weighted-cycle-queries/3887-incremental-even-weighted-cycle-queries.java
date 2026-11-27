// https://leetcode.com/problems/incremental-even-weighted-cycle-queries/
class Solution {
    private int[] parent;
    private int[] rank;
    private int[] parity; // parity[i] = XOR parity from i to its root

    private int[] find(int x) {
        if (parent[x] != x) {
            int[] res = find(parent[x]);
            parity[x] ^= parity[parent[x]];
            parent[x] = res[0];
            return new int[]{res[0], parity[x]};
        }
        return new int[]{x, 0};
    }

    public int incrementalEvenWeightedCycleQueries(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        parity = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int[] ru = find(u);
            int[] rv = find(v);
            int rootU = ru[0], parU = ru[1];
            int rootV = rv[0], parV = rv[1];

            if (rootU != rootV) {
                // Merge components
                if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                    parity[rootU] = parU ^ parV ^ w;
                } else if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                    parity[rootV] = parU ^ parV ^ w;
                } else {
                    parent[rootV] = rootU;
                    parity[rootV] = parU ^ parV ^ w;
                    rank[rootU]++;
                }
                count++;
            } else {
                // Check if adding this edge keeps all cycles even
                if ((parU ^ parV) == (w % 2)) {
                    count++;
                }
            }
        }
        return count;
    }
}
