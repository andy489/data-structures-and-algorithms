# 1976. Number of Ways to Arrive at Destination — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/

---

## Solution: Dijkstra + Count Paths — O((n + e) log n) time, O(n + e) space

**Idea:** Run Dijkstra from node `0`. Maintain both `dist[]` (shortest distances) and `ways[]` (number of ways to reach with shortest distance). When we relax an edge:
- If shorter path found: update `dist[v]` and copy `ways[u]`.
- If equal path found: add `ways[u]` to `ways[v]`.

**Algorithm:**
1. Build adjacency list.
2. Run Dijkstra with priority queue `(dist, node)`.
3. `ways[0] = 1`, `dist[0] = 0`.
4. Return `ways[n-1] % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O((n + e) · log n) |
| Space | O(n + e) |
