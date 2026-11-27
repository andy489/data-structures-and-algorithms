// https://leetcode.com/problems/find-if-path-exists-in-graph/

// Solution: Union-Find — O((n + e) * alpha(n)) time, O(n) space
class Solution {
    private int[] parent;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        return find(source) == find(destination);
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
