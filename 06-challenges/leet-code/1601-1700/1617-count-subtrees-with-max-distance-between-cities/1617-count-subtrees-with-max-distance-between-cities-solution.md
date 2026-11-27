# 1617. Count Subtrees With Max Distance Between Cities — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-subtrees-with-max-distance-between-cities/

---

## Solution: Bitmask Enumeration + BFS — O(2^n * n^2) time, O(n^2) space

**Idea:** Since `n <= 15`, enumerate all `2^n - 1` non-empty subsets of cities via bitmasks. For each subset, verify it forms a connected subtree (the number of edges within the subset = number of nodes - 1), then compute all pairwise distances via BFS to find the diameter.

**Algorithm:**
1. Precompute shortest distances between all pairs using BFS from each node.
2. For each bitmask from `1` to `(1 << n) - 1`:
   a. Collect the set of nodes.
   b. Count edges within the subset. If `edge_count != node_count - 1`, it's not a valid subtree.
   c. Among all pairs in the subset, find the maximum distance (diameter).
   d. Increment `ans[diameter - 1]`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(2^n * n^2) — 2^n subsets, O(n^2) per subset for edge count and diameter |
| Space | O(n^2) — pairwise distance matrix |
