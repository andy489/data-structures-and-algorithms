# 1584. Min Cost to Connect All Points — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/min-cost-to-connect-all-points/

---

## Solution: Prim's Algorithm — O(n^2) time, O(n) space

**Idea:** Build the MST using Prim's algorithm. For dense graphs (complete graph with n^2 edges), Prim's with an array is O(n^2) which is optimal — no heap needed.

**Algorithm:**
1. Initialize `minDist[0] = 0`, all others = infinity.
2. Repeatedly pick the unvisited node `u` with smallest `minDist`, mark it in MST, add `minDist[u]` to total.
3. For each unvisited `v`, update `minDist[v] = min(minDist[v], manhattan(u, v))`.
4. Return total cost.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — n iterations, each scanning n nodes |
| Space | O(n) — minDist and inMST arrays |
