// https://leetcode.com/problems/redundant-connection-ii/

// Solution: Union-Find with Case Analysis — O(n·α(n)) time, O(n) space
class Solution {
    private int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parentOf = new int[n + 1];
        int[] cand1 = null, cand2 = null;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (parentOf[v] != 0) {
                cand1 = new int[]{parentOf[v], v};
                cand2 = edge;
                break;
            }
            parentOf[v] = u;
        }
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (cand2 != null && edge == cand2) {
                continue;
            }
            int u = edge[0], v = edge[1];
            if (find(u) == find(v)) {
                return cand1 == null ? edge : cand1;
            }
            parent[find(v)] = find(u);
        }
        return cand2;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
