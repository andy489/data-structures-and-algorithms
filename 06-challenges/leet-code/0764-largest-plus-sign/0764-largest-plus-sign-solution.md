# 764. Largest Plus Sign — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-plus-sign/

---

## Solution: DP 4-Direction Scan — O(n²) time, O(n²) space

**Idea:** For each cell, compute the maximum consecutive 1s in all four directions. The order of the plus sign at `(r,c)` is `min(left, right, up, down)`. Compute each direction with a single pass.

**Algorithm:**
1. Mark mine positions in a set.
2. For each cell, compute `dp[r][c]` by scanning left, right, up, down — count consecutive 1s.
3. Take the minimum of the four counts. Track overall max.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — 4 passes over the grid |
| Space | O(n²) — DP table |
