# 375. Guess Number Higher or Lower II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/guess-number-higher-or-lower-ii/

---

## Solution: Interval DP — O(n³) time, O(n²) space

**Idea:** `dp[i][j]` = minimum cost to guarantee a win on range `[i, j]`. For each pivot `k` we pay `k` plus the worst of the two sub-ranges.

**Algorithm:**
1. `dp[i][i] = 0` for all `i`.
2. For increasing range length `len`: `dp[i][j] = min over k in [i,j] of { k + max(dp[i][k-1], dp[k+1][j]) }`.
3. Answer is `dp[1][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) |
| Space | O(n²) |
