# 1595. Minimum Cost to Connect Two Groups of Points — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/

---

## Solution: DP with Bitmask — O(m * 2^n * n) time, O(m * 2^n) space

**Idea:** Use bitmask DP where `dp[mask]` = minimum cost after assigning all left-group points, with `mask` representing which right-group points have been covered. After processing all left points, pay the cheapest possible cost to cover any uncovered right points.

**Algorithm:**
1. Precompute `minCostRight[j]` = cheapest connection from any left point to right point `j`.
2. DP: for each left point `i`, transition: `ndp[mask | (1 << j)] = min(..., dp[mask] + cost[i][j])` for all `j`.
3. After all left points, for each `mask`, add `minCostRight[j]` for each uncovered `j`.
4. Return the minimum over all masks.

**Complexity:**

| | |
|---|---|
| Time | O(m * 2^n * n) — m left points, 2^n masks, n right points |
| Space | O(2^n) — DP array (rolling) |
