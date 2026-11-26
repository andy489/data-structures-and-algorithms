// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

// Solution: Kruskal Variants — O(E^2 * alpha(n)) time, O(E) space
class Solution {
    int[] parent, rank;
    int find(int x) { return parent[x] == x ? x : (parent[x] = find(parent[x])); }
    boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        if (rank[a] < rank[b]) { int t = a; a = b; b = t; }
        parent[b] = a;
        if (rank[a] == rank[b]) rank[a]++;
        return true;
    }
    int kruskal(int n, int[][] edges, int skip, int force) {
        parent = new int[n]; rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int w = 0, cnt = 0;
        if (force >= 0) {
            union(edges[force][0], edges[force][1]);
            w += edges[force][2]; cnt++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (i == skip) continue;
            if (union(edges[i][0], edges[i][1])) { w += edges[i][2]; cnt++; }
        }
        return cnt == n - 1 ? w : Integer.MAX_VALUE;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) idx[i] = i;
        int[][] sorted = edges.clone();
        Arrays.sort(idx, (a, b) -> sorted[a][2] - sorted[b][2]);
        int[][] se = new int[m][3];
        for (int i = 0; i < m; i++) se[i] = edges[idx[i]];
        int base = kruskal(n, se, -1, -1);
        List<Integer> crit = new ArrayList<>(), pseudo = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (kruskal(n, se, i, -1) > base) crit.add(idx[i]);
            else if (kruskal(n, se, -1, i) == base) pseudo.add(idx[i]);
        }
        return Arrays.asList(crit, pseudo);
    }
}
