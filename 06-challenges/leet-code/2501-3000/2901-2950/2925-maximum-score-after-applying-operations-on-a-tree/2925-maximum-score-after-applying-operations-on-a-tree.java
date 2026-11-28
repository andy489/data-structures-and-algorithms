// https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/

// Solution: Tree DP (DFS) — O(n) time, O(n) space
class Solution {
    private List<List<Integer>> adj;
    private int[] values;

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        this.values = values;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long total = 0;
        for (int v : values) {
            total += v;
        }
        return total - dfs(0, -1);
    }

    private long dfs(int node, int parent) {
        long childKeep = 0;
        boolean isLeaf = true;
        for (int child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            isLeaf = false;
            childKeep += dfs(child, node);
        }
        if (isLeaf) {
            return values[node];
        }
        return Math.min(values[node], childKeep);
    }
}
