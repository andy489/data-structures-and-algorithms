// https://leetcode.com/problems/maximum-path-quality-of-a-graph/

// Solution: DFS with Backtracking — O(n * maxTime) time, O(n) space
class Solution {
    private int res = 0;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) { adj[i] = new ArrayList<>(); }
        for (int[] e : edges) { adj[e[0]].add(new int[]{e[1], e[2]}); adj[e[1]].add(new int[]{e[0], e[2]}); }
        dfs(0, 0, values[0], values, adj, new int[n], maxTime);
        return res;
    }

    private void dfs(int node, int time, int quality, int[] values, List<int[]>[] adj, int[] cnt, int maxTime) {
        if (node == 0) { res = Math.max(res, quality); }
        for (int[] next : adj[node]) {
            int v = next[0], w = next[1];
            if (time + w <= maxTime) {
                cnt[v]++;
                dfs(v, time + w, quality + (cnt[v] == 1 ? values[v] : 0), values, adj, cnt, maxTime);
                cnt[v]--;
            }
        }
    }
}
