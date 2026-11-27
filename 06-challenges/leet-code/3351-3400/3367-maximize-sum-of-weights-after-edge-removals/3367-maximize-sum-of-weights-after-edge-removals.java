// https://leetcode.com/problems/maximize-sum-of-weights-after-edge-removals/

// Solution: Tree DP (DFS) — O(n log n) time, O(n) space
class Solution {
    private List<int[]>[] adj;
    private int k;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length + 1;
        this.k = k;
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }
        return dfs(0, -1)[0];
    }

    // returns [f0, f1]: max sum without/with keeping edge to parent
    private long[] dfs(int v, int parent) {
        long base = 0;
        List<Long> gains = new ArrayList<>();
        for (int[] edge : adj[v]) {
            int c = edge[0], w = edge[1];
            if (c == parent) {
                continue;
            }
            long[] child = dfs(c, v);
            base += child[0];
            long gain = w + child[1] - child[0];
            gains.add(gain);
        }
        gains.sort(Collections.reverseOrder());

        long f0 = base, f1 = base;
        for (int i = 0; i < gains.size(); i++) {
            if (gains.get(i) <= 0) {
                break;
            }
            if (i < k) {
                f0 += gains.get(i);
            }
            if (i < k - 1) {
                f1 += gains.get(i);
            }
        }
        return new long[]{f0, f1};
    }
}
