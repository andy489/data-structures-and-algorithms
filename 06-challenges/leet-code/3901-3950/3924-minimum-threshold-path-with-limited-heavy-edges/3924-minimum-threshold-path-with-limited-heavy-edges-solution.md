# 3924. Minimum Threshold Path With Limited Heavy Edges — Solution

## Approach: Binary Search + Modified Dijkstra

**Key insight:** Binary search on the threshold value. For a given threshold, we need to check if there exists a path from `source` to `target` using at most `k` heavy edges (edges with weight > threshold).

**Binary search:** The answer is one of the edge weights (or 0 if source == target). Sort unique edge weights and binary search on the threshold.

**Check function:** For a fixed threshold, run a modified Dijkstra where the state is `(node, heavyEdgesUsed)`. We want to find if `(target, h)` is reachable for any `h <= k`. The edge cost used in Dijkstra is the actual edge weight for minimizing travel cost — but here we only need reachability, so we track `dist[node][heavy]` = minimum heavy edges to reach `node` with at most some heavy count.

Since we only need reachability (not minimum weight), we can use BFS with state `(node, heavyCount)`:
- If the edge weight <= threshold, it's light; heavy count stays the same.
- If the edge weight > threshold, it's heavy; heavy count increases by 1.

We check if `(target, h)` is reachable for any `h <= k`.

**Edge case:** If source == target, the answer is 0.

## Complexity

- **Time:** O(E log E * (V + E)) — binary search over edges * BFS per check
- **Space:** O(V * K) — state space for BFS
