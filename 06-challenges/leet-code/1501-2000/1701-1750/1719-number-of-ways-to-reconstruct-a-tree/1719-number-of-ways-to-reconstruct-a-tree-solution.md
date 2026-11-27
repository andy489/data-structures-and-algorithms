# 1719. Number of Ways to Reconstruct a Tree — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-ways-to-reconstruct-a-tree/

---

## Solution: Graph Analysis + Degree Comparison — O(n^2) time, O(n^2) space

**Idea:** Key observations:
1. The root must be connected to all other nodes (its degree = n-1).
2. For each node `u`, its parent `p` must be the neighbor with the smallest degree that is >= deg(u) among ancestors.
3. If deg(parent) == deg(child) and they share the same neighbors, there are multiple valid trees (return 2).
4. If a node's neighbor set is not a subset of its parent's neighbor set, return 0.

**Algorithm:**
1. Build adjacency sets and compute degrees.
2. Sort nodes by degree.
3. For each node, find its "parent" (smallest-degree ancestor neighbor).
4. Verify: parent's neighbors must include all of node's neighbors (minus itself).
5. If deg(parent) == deg(node), mark as multiple (return 2 at the end).
6. Must have exactly one root with degree n-1.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — checking neighbor subsets |
| Space | O(n^2) — adjacency sets |
