// https://leetcode.com/problems/redundant-connection/

// Solution: Union-Find — O(n·α(n)) time, O(n) space
class Solution {
    private int[] parent;
    private int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }
        return new int[0];
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
