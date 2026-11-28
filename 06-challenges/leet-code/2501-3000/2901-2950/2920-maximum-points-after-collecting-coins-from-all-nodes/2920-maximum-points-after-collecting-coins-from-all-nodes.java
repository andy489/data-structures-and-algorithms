// https://leetcode.com/problems/maximum-points-after-collecting-coins-from-all-nodes/

// Solution: Tree DFS with Memoization (halving depth) — O(n log(max_coins)) time, O(n log(max_coins)) space
class Solution {
    List<Integer>[] adj;
    int[] coins;
    int k;
    Map<Integer, Long> memo;

    public long maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        this.coins = coins;
        this.k = k;
        this.memo = new HashMap<>();
        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        return dfs(0, -1, 0);
    }

    private long dfs(int node, int parent, int halvings) {
        if (halvings >= 14) {
            // coins[i] <= 10^4 < 2^14, so after 14 halvings all values are 0
            return 0;
        }
        int key = node * 15 + halvings;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int v = coins[node] >> halvings;

        // Option 1: take v - k, children keep same halvings
        long opt1 = v - k;
        // Option 2: take v >> 1, children get halvings + 1
        long opt2 = v >> 1;

        for (int child : adj[node]) {
            if (child == parent) {
                continue;
            }
            opt1 += dfs(child, node, halvings);
            opt2 += dfs(child, node, halvings + 1);
        }

        long best = Math.max(opt1, opt2);
        memo.put(key, best);
        return best;
    }
}
