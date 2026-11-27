# 1786. Number of Restricted Paths From First to Last Node — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/

---

## Solution: Dijkstra + Memoized DP — O((n + m) log n) time, O(n + m) space

**Idea:** First run Dijkstra from node `n` to get `dist[v]` = shortest distance from `v` to `n`. A restricted path requires strictly decreasing distances to `n` along the path. Then count paths from node `1` to node `n` using memoized DFS: `dp[u]` = number of restricted paths from `u` to `n`, where we can move from `u` to neighbor `v` only if `dist[v] < dist[u]`.

**Algorithm:**
1. Build adjacency list.
2. Run Dijkstra from node `n` (reverse edges are undirected, so just run from `n`).
3. Use memoized DFS: `dp[n] = 1`. For each node `u`, sum `dp[v]` for all neighbors `v` where `dist[v] < dist[u]`.
4. Return `dp[1] % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O((n + m) log n) — Dijkstra dominates |
| Space | O(n + m) — adjacency list and DP table |
