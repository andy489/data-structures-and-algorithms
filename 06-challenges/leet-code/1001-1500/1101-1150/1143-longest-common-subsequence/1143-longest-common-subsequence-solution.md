# 1143. Longest Common Subsequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-common-subsequence/

---

## Solution: 2D DP — O(m*n) time, O(m*n) space

**Idea:** `dp[i][j]` = LCS length of `text1[0..i-1]` and `text2[0..j-1]`. If characters match, extend the LCS from `dp[i-1][j-1]`; otherwise take the max of skipping one character from either string.

**Algorithm:**
1. Initialize `dp[0][j] = dp[i][0] = 0`.
2. For each `(i, j)`: if `text1[i-1] == text2[j-1]`, `dp[i][j] = dp[i-1][j-1] + 1`; else `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.
3. Return `dp[m][n]`.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(m * n) |

---

## Solution 2: 1D DP (Space-Optimised) — O(m*n) time, O(min(m,n)) space

**Idea:** We only need the previous row to compute the current row. Use a single rolling array and a variable `prev` to hold `dp[i-1][j-1]`.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(min(m, n)) |
