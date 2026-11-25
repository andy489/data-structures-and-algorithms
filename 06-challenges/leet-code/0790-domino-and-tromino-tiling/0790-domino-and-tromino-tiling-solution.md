# 790. Domino and Tromino Tiling — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/domino-and-tromino-tiling/

---

## Solution: Dynamic Programming — O(n) time, O(n) space

**Idea:** Let `dp[i]` = number of ways to fully tile a 2×i board. The recurrence is `dp[i] = 2*dp[i-1] + dp[i-3]`. This comes from the closed-form analysis of domino+tromino configurations.

**Algorithm:**
1. Base cases: dp[1]=1, dp[2]=2, dp[3]=5.
2. For i ≥ 4: dp[i] = (2*dp[i-1] + dp[i-3]) % MOD.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — dp array |
