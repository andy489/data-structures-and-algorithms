# 1277. Count Square Submatrices with All Ones — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-square-submatrices-with-all-ones/

---

## Solution: Dynamic Programming — O(m*n) time, O(1) — in-place space

**Idea:** dp[i][j] = side length of largest square with bottom-right corner at (i,j). The number of squares ending at (i,j) equals dp[i][j].

**Algorithm:**
1. If matrix[i][j] == 0: dp[i][j] = 0.
2. Else: dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1.
3. Sum all dp values.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(1) — in-place |
