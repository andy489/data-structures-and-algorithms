# 743. Network Delay Time — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/network-delay-time/

---

## Solution: Dijkstra's Algorithm — O((V + E) log V) time, O(V + E) space

**Idea:** Single-source shortest paths from node `k`. The answer is the max shortest-path distance to any node. If any node is unreachable, return -1.

**Algorithm:**
1. Build adjacency list.
2. Run Dijkstra from `k` using a min-heap.
3. Return `max(dist)` if all nodes reached, else `-1`.

**Complexity:**

| | |
|---|---|
| Time | O((V + E) log V) — Dijkstra with heap |
| Space | O(V + E) — adjacency list + dist array |
