# 1824. Minimum Sideway Jumps — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-sideway-jumps/

---

## Solution: Greedy DP — O(n) time, O(1) space

**Idea:** Maintain a DP array `dp[0..2]` representing the minimum sideway jumps to be on each of the 3 lanes (0-indexed) at the current point. At each point, if there is an obstacle on a lane, set that lane's cost to infinity. Then the cost of any non-blocked lane can be updated to `min(dp[lane], minCost + 1)` where `minCost` is the minimum across all lanes — a sideway jump from the cheapest lane costs 1 extra jump.

**Algorithm:**
1. Initialize `dp = [1, 0, 1]` — frog starts on lane 2 (index 1), costing 0; jumping to lanes 1 or 3 costs 1.
2. For each point from index 1 to n:
   - Convert obstacle to 0-indexed. If valid, set `dp[obs] = INF`.
   - Compute `minCost = min(dp)`.
   - For each non-blocked lane: `dp[lane] = min(dp[lane], minCost + 1)`.
3. Return `min(dp)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one pass, constant work per point (3 lanes) |
| Space | O(1) — fixed-size dp array of length 3 |
