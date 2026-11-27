# 547. Number of Provinces — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-provinces/

---

## Solution: Union-Find — O(n^2 · α(n)) time, O(n) space

**Idea:** Each city is a node. Union connected cities; count distinct roots.

**Algorithm:**
1. Initialize `parent[i] = i`.
2. For each pair `(i, j)` where `isConnected[i][j] == 1`: union `i` and `j`.
3. Count nodes where `find(i) == i` — each is a province root.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 · α(n)) — scan all pairs; near-O(1) per union with path compression |
| Space | O(n) — parent array |
