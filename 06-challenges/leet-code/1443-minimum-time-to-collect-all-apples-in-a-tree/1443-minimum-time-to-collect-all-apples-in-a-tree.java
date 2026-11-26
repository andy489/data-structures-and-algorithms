// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/

// Solution: DFS — O(n) time, O(n) space
class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) { adj.get(e[0]).add(e[1]); adj.get(e[1]).add(e[0]); }
        return dfs(0, -1, adj, hasApple);
    }
    private int dfs(int u, int parent, List<List<Integer>> adj, List<Boolean> hasApple) {
        int total = 0;
        for (int v : adj.get(u)) {
            if (v == parent) continue;
            int cost = dfs(v, u, adj, hasApple);
            if (cost > 0 || hasApple.get(v)) total += cost + 2;
        }
        return total;
    }
}
