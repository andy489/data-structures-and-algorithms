// https://leetcode.com/problems/find-number-of-coins-to-place-in-tree-nodes/
class Solution {
    private List<Integer>[] adj;
    private long[] coins;
    private int[] cost;

    public long[] placedCoins(int[][] edges, int[] cost) {
        int n = cost.length;
        this.cost = cost;
        this.coins = new long[n];
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        dfs(0, -1);
        return coins;
    }

    private List<Integer> dfs(int node, int parent) {
        List<Integer> subtree = new ArrayList<>();
        subtree.add(cost[node]);
        for (int child : adj[node]) {
            if (child != parent) {
                subtree.addAll(dfs(child, node));
            }
        }
        int size = subtree.size();
        if (size < 3) {
            coins[node] = 1;
        } else {
            Collections.sort(subtree);
            long opt1 = (long) subtree.get(size - 1) * subtree.get(size - 2) * subtree.get(size - 3);
            long opt2 = (long) subtree.get(0) * subtree.get(1) * subtree.get(size - 1);
            coins[node] = Math.max(0, Math.max(opt1, opt2));
        }
        // Keep only top 3 largest and bottom 2 smallest
        if (subtree.size() > 5) {
            List<Integer> trimmed = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                trimmed.add(subtree.get(i));
            }
            for (int i = size - 3; i < size; i++) {
                trimmed.add(subtree.get(i));
            }
            return trimmed;
        }
        return subtree;
    }
}
