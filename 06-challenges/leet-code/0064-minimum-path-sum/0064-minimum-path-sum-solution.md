# 64. Minimum Path Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-path-sum/

---

## Solution: DP (1D Space-Optimized) — O(m·n) time, O(n) space

**Idea:** Same rolling-row DP pattern as LC 62/63. `dp[j]` holds the minimum path sum to reach the cell in the current row at column `j`. Initialize the first row as a prefix sum, then for each subsequent row update `dp[0]` by adding the cell value (only path is from above), and for `j > 0` take the minimum of coming from above (`dp[j]`) or from the left (`dp[j-1]`).

**Algorithm:**
1. Initialize `dp[n]` with prefix sums of the first row.
2. For each row `i` from `1` to `m-1`:
   - `dp[0] += grid[i][0]` (can only come from above).
   - For `j` from `1` to `n-1`: `dp[j] = grid[i][j] + min(dp[j], dp[j-1])`.
3. Return `dp[n-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — one pass over all cells |
| Space | O(n) — single row |
