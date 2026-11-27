# 882. Reachable Nodes in Subdivided Graph — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/

---

## Solution: Dijkstra — O((n + e) log n) time, O(n + e) space

**Idea:** Dijkstra from node 0 with max remaining moves. For each original node reached, add 1. For each edge between u and v, the number of subdivided nodes reachable is min(cnt, moves_u) + min(cnt, moves_v), capped at cnt.

**Algorithm:**
1. Dijkstra: dist[u] = max moves remaining when reaching u.
2. After Dijkstra, count original nodes with dist[u] >= 0 (reachable).
3. For each edge (u, v, cnt): sub-nodes reachable = min(dist[u], cnt) + min(dist[v], cnt), capped at cnt.
4. Sum original + subdivided nodes.

**Complexity:**

| | |
|---|---|
| Time | O((n + e) log n) |
| Space | O(n + e) |
