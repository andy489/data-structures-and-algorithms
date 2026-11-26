# 834. Sum of Distances in Tree — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/sum-of-distances-in-tree/

---

## Solution: Two-Pass DFS — O(n) time, O(n) space

**Idea:** First DFS from root: compute count[v] (subtree size) and ans[0] (sum of distances from root). Second DFS: re-root the tree, using the relation ans[child] = ans[parent] - count[child] + (n - count[child]).

**Algorithm:**
1. DFS1 from root 0: count[v] = subtree size, ans[0] = total distances from 0.
2. DFS2: for each child c of parent p: ans[c] = ans[p] - count[c] + (n - count[c]).

**Complexity:**

| | |
|---|---|
| Time | O(n) — two DFS passes |
| Space | O(n) — adjacency list and arrays |
