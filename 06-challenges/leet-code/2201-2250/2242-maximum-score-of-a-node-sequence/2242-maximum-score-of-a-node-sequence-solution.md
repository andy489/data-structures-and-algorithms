# 2242. Maximum Score of a Node Sequence

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/maximum-score-of-a-node-sequence/

## Approach: Top-3 Neighbors per Node

For each edge (u, v), the best 4-node sequence containing this edge as the middle edge is:
`a - u - v - b` where a is a neighbor of u (a != v, a != b) and b is a neighbor of v (b != u, b != a), maximizing scores[a] + scores[u] + scores[v] + scores[b].

To efficiently find the best endpoints, for each node keep only the top 3 neighbors by score. For each edge, try all 3x3 combinations of top neighbors.

**Algorithm:**
1. For each node, store top 3 neighbors sorted by score descending.
2. For each edge (u, v), iterate over top-3 of u and top-3 of v.
3. If the two chosen endpoints are distinct and different from u and v, compute the total score and update the max.

**Why top 3?** At most one of the top 3 neighbors of u equals v or equals the best neighbor of v, so we always find a valid pair.

**Complexity:**
- Time: O(n + e) where e is number of edges
- Space: O(n)
