# 310. Minimum Height Trees — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-height-trees/

---

## Solution: Topological Sort (Leaf Trimming) — O(n) time, O(n) space

**Idea:** Repeatedly prune leaf nodes. The last 1 or 2 nodes are the centroids — roots of minimum height trees.

**Algorithm:**
1. Build adjacency sets and collect initial leaves (degree 1).
2. While more than 2 nodes remain: remove leaves, find new leaves.
3. Return remaining nodes.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
