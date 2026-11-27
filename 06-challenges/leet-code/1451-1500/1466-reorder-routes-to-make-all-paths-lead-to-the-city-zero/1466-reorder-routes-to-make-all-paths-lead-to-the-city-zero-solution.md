# 1466. Reorder Routes To Make All Paths Lead To The City Zero — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

---

## Solution: BFS from Root — O(n) time, O(n) space

**Idea:** Build undirected adjacency with edge weight: 1 if original direction (away from 0), 0 if reversed. BFS from 0, counting cost.

**Algorithm:**
1. Build adj with (neighbor, cost) pairs.
2. BFS from 0. For each edge traversed: if cost==1, we need to reverse it, count++.
3. Return count.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
