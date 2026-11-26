# 664. Strange Printer — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/strange-printer/

---

## Solution: Interval DP — O(n³) time, O(n²) space

**Idea:** `dp[i][j]` = minimum turns to print `s[i..j]`. If `s[i] == s[k]` for some `k` in `[i+1, j]`, we can merge the print of `s[i]` and `s[k]` without extra cost.

**Algorithm:**
1. Base: `dp[i][i] = 1`.
2. For each interval length `len` from 2 to n:
   - `dp[i][j] = dp[i+1][j] + 1` (print `s[i]` alone, then handle rest).
   - For each `k` from `i+1` to `j`: if `s[i] == s[k]`, then `dp[i][j] = min(dp[i][j], dp[i+1][k] + dp[k][j])`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) |
| Space | O(n²) |
