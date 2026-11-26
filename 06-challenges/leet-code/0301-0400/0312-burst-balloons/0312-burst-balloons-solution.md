# 312. Burst Balloons — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/burst-balloons/

---

## Solution: Interval DP — O(n³) time, O(n²) space

**Idea:** Define `dp[l][r]` = max coins by bursting all balloons strictly between `l` and `r`. Key insight: think of k as the **last** balloon burst in interval (l,r).

**Algorithm:**
1. Pad array with 1s on both sides.
2. For each interval length from 2 to n+1: for each l, r: try each k as last burst: `dp[l][r] = max(dp[l][k] + arr[l]*arr[k]*arr[r] + dp[k][r])`.
3. Return `dp[0][n+1]`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) |
| Space | O(n²) |
