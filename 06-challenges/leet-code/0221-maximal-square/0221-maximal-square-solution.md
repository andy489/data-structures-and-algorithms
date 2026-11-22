# 221. Maximal Square — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximal-square/

---

## Solution: 2D DP — O(m·n) time, O(m·n) space

**Idea:** `dp[i][j]` = side length of the largest square whose bottom-right corner is `(i, j)`. If `matrix[i][j] == '1'`, then `dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1`.

**Algorithm:**
1. Create `dp[m][n]`, initialise first row and column directly from the matrix.
2. For `i >= 1`, `j >= 1`: if `matrix[i][j] == '1'`, apply the recurrence; else `dp[i][j] = 0`.
3. Track the maximum value seen; return `max * max`.

## Solution 2: O(n) Space DP — O(m·n) time, O(n) space

**Idea:** Reuse a single 1D array plus one variable `prev` to represent `dp[i-1][j-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) |
| Space | O(m·n) for 2D DP, O(n) for 1D variant |
