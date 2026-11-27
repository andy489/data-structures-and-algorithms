# 399. Evaluate Division — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/evaluate-division/

---

## Solution: Graph BFS — O((V+E) · Q) time, O(V+E) space

**Idea:** Build a weighted directed graph: edge `a → b` with weight `v` and `b → a` with weight `1/v`. For each query `(C, D)`, BFS/DFS from C to D, multiplying edge weights along the path.

**Algorithm:**
1. Build adjacency list from equations and values (both directions).
2. For each query, BFS from source; track visited nodes and accumulated product.
3. If destination unreachable or variables unknown: return -1.0.

**Complexity:**

| | |
|---|---|
| Time | O((V+E) · Q) where Q = queries count |
| Space | O(V+E) — adjacency list |
