# 63. Unique Paths II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/unique-paths-ii/

---

## Solution: DP (1D Space-Optimized) — O(m·n) time, O(n) space

**Idea:** Same 1D rolling-row DP as LC 62, but set `dp[j] = 0` whenever a cell is an obstacle. Initialize `dp[0] = 1` only if `obstacleGrid[0][0] == 0`, then propagate the first row (zeroing out any obstacle). For subsequent rows, reset `dp[0]` to `0` if that cell is an obstacle, then update left-to-right.

**Algorithm:**
1. Initialize `dp = [0] * n`. Set `dp[0] = 1` if no obstacle at start.
2. Fill first row: `dp[j] = dp[j-1] if obstacleGrid[0][j] == 0 else 0`.
3. For each row `i` from `1` to `m-1`:
   - If `obstacleGrid[i][0] == 1`, set `dp[0] = 0`.
   - For `j` from `1` to `n-1`: `dp[j] = dp[j] + dp[j-1]` if no obstacle, else `dp[j] = 0`.
4. Return `dp[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — one pass over all cells |
| Space | O(n) — single row |
